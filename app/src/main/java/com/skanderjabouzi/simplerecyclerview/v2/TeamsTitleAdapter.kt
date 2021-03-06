package com.hackertronix.mergeadaptersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skanderjabouzi.simplerecyclerview.R

class TeamsTitleAdapter() :
        RecyclerView.Adapter<TeamsTitleAdapter.TeamTitlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamTitlesViewHolder {
        val view =
                LayoutInflater.from(parent.context).inflate(R.layout.teams_titles, parent, false)
        return TeamTitlesViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = R.layout.teams_titles

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: TeamTitlesViewHolder, position: Int) {}

    inner class TeamTitlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}