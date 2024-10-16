package com.cgvsu.calculator;

import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Polygon;

import java.util.ArrayList;

public class PolygonNormalCalculator {

    public static Vector3f calculateNormal(Polygon polygon, ArrayList<Vector3f> vertices) {
        // Получаем индексы вершин полигона
        ArrayList<Integer> vertexIndices = polygon.getVertexIndices();

        // Убеждаемся, что у нас как минимум 3 вершины
        if (vertexIndices.size() < 3) {
            throw new IllegalArgumentException("Polygon must have at least 3 vertex indices.");
        }

        // Получаем координаты 3-х вершин
        Vector3f v1 = vertices.get(vertexIndices.get(0));
        Vector3f v2 = vertices.get(vertexIndices.get(1));
        Vector3f v3 = vertices.get(vertexIndices.get(2));

        // Вычисляем векторы
        Vector3f VecA = v2.subtract(v1);
        Vector3f VecB = v3.subtract(v1);

        // Вычисляем нормаль с помощью векторного произведения
        Vector3f normal = VecA.cross(VecB).normalize(); // normalize для единичного вектора

        return normal;
    }
}