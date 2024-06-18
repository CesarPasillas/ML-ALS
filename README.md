# Machine Learning (ALS Model)

:construction: Proyecto en construcción :construction:

![Version](https://img.shields.io/badge/Version-0.1-blue)

[![Autor](https://img.shields.io/badge/Author-Cesar_"Aran"_Pasillas-black)](https://programmingsquirrel.wordpress.com/about-me/)


## Technologies
- **Java 11**
- **Apache Spark 3.3.0**

## Description
This project is a basic example of Machine Learning with Java, this project uses the ALS Model.

## What is the ALS Model?

**The ALS Model (Alternating Least Squares)** is a widely used machine learning algorithm in collaborative recommendation systems. It was popularized by Koren et al.'s work in the Netflix Prize, where it was used to significantly improve the accuracy of recommendations in Netflix's movie streaming service.

### Functioning of the ALS Model

The ALS model is primarily used for collaborative filtering, a technique for making recommendations based on similar users. The basic idea behind ALS is to decompose a matrix of user-item interaction data (e.g., movie ratings by users) into two smaller matrices:

- **User Matrix (U)**: Represents the relationship between users and latent features.
- **Item Matrix (V)**: Represents the relationship between items (e.g., movies) and the same latent features.

These latent features are unobservable attributes that capture the underlying preferences and characteristics of both users and items. The goal of ALS is to fit these two matrices such that their product approximates the original ratings (or interactions) matrix.

### Training Process

The training process of the ALS model generally involves the following steps:

1. **Initialization**: U and V matrices are randomly initialized.

2. **Alternating Least Squares Update**:

- Update the User Matrix U: Fixing the Item Matrix V, calculate the best approximation of U using least squares.
- Update the Item Matrix V: Fixing the User Matrix U, calculate the best approximation of V using least squares.

This process iterates until converging to a solution where the approximation of the original matrix is optimal according to some criterion (usually minimizing the squared error).

### Advantages of the ALS Model

- **Scalability**: ALS is highly scalable and efficient for large datasets, which is crucial in real-time recommendation applications.
- **Ease of Implementation**: It is relatively straightforward to implement and can effectively handle sparse data and large matrices.
- **Good Generalization**: The model can generalize well to new users or items with few data points, as it captures latent patterns rather than relying solely on similarity between users or items.

### Use in Recommendation Systems

In recommendation systems, the ALS model is used to predict a user's preference for an item they have not yet interacted with. This allows for generating personalized recommendations based on the historical preferences of similar users.

### Implementation in Apache Spark MLlib

In Apache Spark, MLlib (Machine Learning Library) provides an efficient implementation of the ALS model for distributed processing of large datasets. It allows training ALS models using Spark's Resilient Distributed Datasets (RDDs) and can be easily scaled across distributed computing clusters.

<a href="https://programmingsquirrel.wordpress.com/">
  <img src="https://programmingsquirrel.wordpress.com/wp-content/uploads/2023/05/logo_ardilla_programmer_blue.png" alt="Programmer Squirrel" width="150" height="150">
</a>
