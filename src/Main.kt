import java.io.File
const val fileName = "triangle_between_points.html"
const val width = 600
const val height = 500
const val numTriangles = 200

fun main() {
    val canvas = DrawTriangle.drawCanvas(width, height)
    File(fileName).writeText(canvas)
    val resTriangles = DivideTriangles.divideTriangles(mutableSetOf(triangleABC))
    for (triangle in resTriangles)
        DrawTriangle.drawTriangle(triangle, fileName)
}
