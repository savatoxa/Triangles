object DivideTriangles {
    fun divideTriangle (triangle: Triangle) : Triangle{
        val divide = fun(point1: Point2D, point2: Point2D): Point2D = Point2D((point1.x + point2.x)/2, (point1.y + point2.y)/2)
        return Triangle(divide(triangle.A,triangle.B), divide(triangle.B,triangle.C), divide(triangle.C,triangle.A))
    }
    fun addMissingTriangles(triangle: Triangle) : MutableList<Triangle>{
        val newTriangle = divideTriangle(triangle)
        val newTriangleLeft = Triangle(newTriangle.A, triangle.B, newTriangle.B)
        val newTriangleRight = Triangle(newTriangle.C, newTriangle.B, triangle.C)
        val newTriangleUpper = Triangle(triangle.A, newTriangle.A, newTriangle.C)
        return mutableListOf(newTriangle, newTriangleLeft, newTriangleRight, newTriangleUpper)
    }
    fun divideTriangles (triangles: MutableList<Triangle>, startIdx: Int = 0) :  MutableList<Triangle>{
        if(triangles.count() < numTriangles) {
            val endIdx = triangles.size
            for (i in startIdx until endIdx) {
                triangles.addAll(addMissingTriangles(triangles[i]))
            }
            return divideTriangles(triangles, startIdx = endIdx)
        }
        else
            return triangles
    }
}