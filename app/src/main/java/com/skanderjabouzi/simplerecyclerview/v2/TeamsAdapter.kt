package com.hackertronix.mergeadaptersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skanderjabouzi.simplerecyclerview.R
import com.skanderjabouzi.simplerecyclerview.v2.Team
import kotlinx.android.synthetic.main.teams_item.view.*

class TeamsAdapter() :
        RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    var teams = listOf<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view =
                LayoutInflater.from(parent.context).inflate(R.layout.teams_item, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = R.layout.teams_item


    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(team: Team) {
            itemView.team_name_value.text = team.name
            itemView.team_wins_value.text = team.wins.toString()
            itemView.team_losses_value.text = team.losses.toString()
        }
    }
}