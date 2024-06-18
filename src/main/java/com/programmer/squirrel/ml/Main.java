package com.programmer.squirrel.ml;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;

import java.util.Arrays;
import java.util.List;

/**
 * Created for the Default (Template) Project project.
 *
 * @author cesarpasillas
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        // Configurar Spark
        SparkConf conf = new SparkConf().setAppName("ALS Example").setMaster("local[*]");

        try (JavaSparkContext sc = new JavaSparkContext(conf)) {

            // Crear datos de ejemplo
            List<Rating> ratingsList = Arrays.asList(
                    new Rating(1, 1, 5.0),
                    new Rating(1, 2, 1.0),
                    new Rating(2, 1, 1.0),
                    new Rating(2, 2, 5.0)
            );
            JavaRDD<Rating> ratingsRDD = sc.parallelize(ratingsList);

            // Entrenar el modelo ALS
            int rank = 10; // Número de características latentes
            int numIterations = 10; // Número de iteraciones (épocas)
            double lambda = 0.01; // Factor de regularización

            MatrixFactorizationModel model = ALS.train(JavaRDD.toRDD(ratingsRDD), rank, numIterations, lambda);

            // Realizar predicciones (en este caso, solo estamos imprimiendo las recomendaciones para el usuario 1)
            Rating[] user1Products = model.recommendProducts(1, 2); // Recomendar 2 productos para el usuario 1
            System.out.println("Recomendaciones para el usuario 1:");
            for (Rating r : user1Products) {
                System.out.println("Producto " + r.product() + " con puntuación " + r.rating());
            }
            // Detener el contexto de Spark
            sc.stop();
        } catch (Exception e){
           e.printStackTrace();
        }







    }
}