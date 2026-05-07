package com.azizkhodja.portfolio.ui.projects

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azizkhodja.portfolio.data.Project
import com.azizkhodja.portfolio.databinding.ItemProjectBinding

class ProjectAdapter(
    private val projects: List<Project>,
    private val onClick: (Project) -> Unit
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    inner class ProjectViewHolder(
        private val binding: ItemProjectBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(project: Project) {
            binding.projectName.text = project.name
            binding.projectTech.text = project.technologies
            binding.projectDescription.text = project.description
            binding.root.setOnClickListener { onClick(project) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = ItemProjectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    override fun getItemCount(): Int = projects.size
}
