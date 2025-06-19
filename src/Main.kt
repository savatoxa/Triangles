import java.io.File
const val fileName = "triangle_between_points.html"
const val width = 600
const val height = 500

fun main() {
    triangleABC.printTriangle()

    val canvas = DrawTriangle.drawCanvas(width, height)
    File(fileName).writeText(canvas)
    val newtriangle = DivideTriangles.divideTriangle(triangleABC)
    DrawTriangle.drawTriangle(triangleABC, fileName)
    DrawTriangle.drawTriangle(newtriangle, fileName)
}
