package com.azizkhodja.portfolio.ui.about

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.azizkhodja.portfolio.R
import com.azizkhodja.portfolio.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderSkills()
    }

    private fun renderSkills() {
        val skills = getString(R.string.about_skills_value)
            .split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        val ctx = requireContext()
        binding.skillsContainer.removeAllViews()

        var rowLayout: LinearLayout? = null
        skills.forEachIndexed { index, skill ->
            if (index % 3 == 0) {
                rowLayout = LinearLayout(ctx).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply { topMargin = dp(8) }
                    orientation = LinearLayout.HORIZONTAL
                }
                binding.skillsContainer.addView(rowLayout)
            }
            val chip = TextView(ctx).apply {
                text = skill
                setBackgroundResource(R.drawable.bg_chip_tech)
                setTextColor(ContextCompat.getColor(ctx, R.color.primary))
                textSize = 13f
                gravity = Gravity.CENTER
                val lp = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { rightMargin = dp(8) }
                layoutParams = lp
            }
            rowLayout?.addView(chip)
        }
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
