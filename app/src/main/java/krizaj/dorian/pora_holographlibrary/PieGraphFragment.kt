package krizaj.dorian.pora_holographlibrary

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.echo.holographlibrary.PieGraph
import com.echo.holographlibrary.PieSlice

class PieGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pie_graph, container, false)
        val pieGraph = view.findViewById<PieGraph>(R.id.pieGraph)
        val legendContainer = view.findViewById<LinearLayout>(R.id.legendContainer)

        val slices = listOf(
            PieSlice().apply {
                setColor(Color.parseColor("#FF5722"))
                setValue(30f)
                setTitle("Slice 1")
            },
            PieSlice().apply {
                setColor(Color.parseColor("#4CAF50"))
                setValue(20f)
                setTitle("Slice 2")
            },
            PieSlice().apply {
                setColor(Color.parseColor("#2196F3"))
                setValue(25f)
                setTitle("Slice 3")
            },
            PieSlice().apply {
                setColor(Color.parseColor("#FFC107"))
                setValue(15f)
                setTitle("Slice 4")
            },
            PieSlice().apply {
                setColor(Color.parseColor("#9C27B0"))
                setValue(10f)
                setTitle("Slice 5")
            }
        )

        slices.forEach { slice ->
            pieGraph.addSlice(slice)
            addLegend(legendContainer, slice)
        }

        return view
    }

    private fun addLegend(container: LinearLayout, slice: PieSlice) {
        val legend = TextView(context).apply {
            text = slice.title
            setTextColor(slice.color)
            textSize = 16f
            setPadding(0, 8, 0, 8)
        }
        container.addView(legend)
    }
}