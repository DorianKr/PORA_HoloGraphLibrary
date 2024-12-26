package krizaj.dorian.pora_holographlibrary

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.echo.holographlibrary.Line
import com.echo.holographlibrary.LineGraph
import com.echo.holographlibrary.LinePoint

class LineGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_line_graph, container, false)
        val lineGraph = view.findViewById<LineGraph>(R.id.lineGraph)

        val line = Line().apply {
            addPoint(LinePoint().apply {
                setX(0f)
                setY(5f)
            })
            addPoint(LinePoint().apply {
                setX(8f)
                setY(8f)
            })
            addPoint(LinePoint().apply {
                setX(10f)
                setY(4f)
            })
            setColor(Color.parseColor("#FFBB33"))
        }

        lineGraph.addLine(line)
        lineGraph.setRangeY(0f, 10f)
        lineGraph.setLineToFill(0)

        lineGraph.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                for (point in line.points) {
                    val x = point.x * lineGraph.width / 10
                    val y = lineGraph.height - (point.y * lineGraph.height / 10)
                    if (Math.abs(event.x - x) < 20 && Math.abs(event.y - y) < 20) {
                        Toast.makeText(context, "(${point.x}, ${point.y})", Toast.LENGTH_SHORT).show()
                        return@setOnTouchListener true
                    }
                }
            }
            false
        }

        return view
    }
}