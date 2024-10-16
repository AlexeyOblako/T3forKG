package com.cgvsu.math;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector3f {
    float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Vector3f other) {
        final float eps = 1e-7f;
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
    }

    // Метод для вычисления вектора между двумя вершинами
    public Vector3f subtract(Vector3f other) {
        return new Vector3f(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Метод для векторного произведения
    public Vector3f cross(Vector3f other) {
        float resultX = this.y * other.z - this.z * other.y;
        float resultY = this.z * other.x - this.x * other.z;
        float resultZ = this.x * other.y - this.y * other.x;
        return new Vector3f(resultX, resultY, resultZ);
    }

    // Метод для нормализации вектора
    public Vector3f normalize() {
        float length = (float)Math.sqrt(x * x + y * y + z * z);
        if (length == 0) {
            throw new IllegalArgumentException("Cannot normalize a zero vector.");
        }
        return new Vector3f(x / length, y / length, z / length);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return String.format("(%.6f, %.6f, %.6f)", x, y, z);
    }
}