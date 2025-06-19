object DivideTriangles {
    fun divideTriangle (triangle: Triangle) : Triangle{
        val divide = fun(point1: Point2D, point2: Point2D): Point2D = Point2D((point1.x + point2.x)/2, (point1.y + point2.y)/2)
        return Triangle(divide(A,B), divide(B,C), divide(C,A))
    }
    fun divideTriangles (triangles: List<Triangle>) : List<Triangle>{

        return triangles
    }
}