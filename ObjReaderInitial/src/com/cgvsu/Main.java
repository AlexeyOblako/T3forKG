package com.cgvsu;

import com.cgvsu.calculator.PolygonNormalCalculator;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;
import com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // Ваша логика загрузки модели
        Path fileName = Path.of("../../3DModels/Faceform/WrapHead.obj");
        String fileContent = Files.readString(Paths.get("C:\\Project\\java\\3sem\\Task3\\ObjReaderInitial\\src\\com\\cgvsu\\caracal_cube.obj"));

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        // Вычисление нормалей
        System.out.println("Calculating normals...");
        for (Polygon polygon : model.polygons) {
            Vector3f normal = PolygonNormalCalculator.calculateNormal(polygon, model.vertices);
            System.out.println("Normal: " + normal);
        }
    }
}