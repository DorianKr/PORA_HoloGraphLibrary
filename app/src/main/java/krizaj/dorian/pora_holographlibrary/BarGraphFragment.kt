package krizaj.dorian.pora_holographlibrary

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph

class BarGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bar_graph, container, false)
        val barGraph = view.findViewById<BarGraph>(R.id.barGraph)

        val points = ArrayList<Bar>()
        val bar1 = Bar().apply {
            color = Color.parseColor("#99CC00")
            name = "Test1"
            value = 10f
        }
        val bar2 = Bar().apply {
            color = Color.parseColor("#FFBB33")
            name = "Test2"
            value = 20f
        }
        points.add(bar1)
        points.add(bar2)

        barGraph.bars = points

        return view
    }
}