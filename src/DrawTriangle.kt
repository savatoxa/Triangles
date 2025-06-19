import java.io.File

object DrawTriangle {
    fun drawCanvas(w: Int, h: Int): String {
        val wstr = w.toString()
        val hstr = h.toString()
        val html = """
       <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Triangle</title>
        </head>
        <body>
            <canvas id="canvas" width="$wstr" height="$hstr" style="border:1px solid black;"></canvas>
            <script>
              const canvas = document.getElementById('canvas');
              const ctx = canvas.getContext('2d');
            </script>
        </body>
        </html>
    """.trimIndent()
        return html
    }

    fun drawTriangle(triangle: Triangle, filePath: String) {
        val file = File(filePath);
        if (!file.exists()) {
            println("file not found: $filePath")
            return
        } else {
            val originalHtml = file.readText()
            val insertBefore = "</script>"
            val triangleJs = """
        ctx.beginPath();
        ctx.moveTo(${triangle.A.x}, ${triangle.A.y});
        ctx.lineTo(${triangle.B.x}, ${triangle.B.y});
        ctx.lineTo(${triangle.C.x}, ${triangle.C.y});
        ctx.closePath();
        ctx.strokeStyle = "blue";
        ctx.lineWidth = 2;
        ctx.stroke();
    """.trimIndent()
            if (!originalHtml.contains(insertBefore)) {
                println("error in original file")
                return
            }
            val updatedHtml = originalHtml.replace(insertBefore, "$triangleJs\n$insertBefore")
            file.writeText(updatedHtml)
        }
    }
}