package com.skanderjabouzi.simplerecyclerview.v2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.google.gson.GsonBuilder
import com.hackertronix.mergeadaptersample.PlayersAdapter
import com.hackertronix.mergeadaptersample.TeamsAdapter
import com.hackertronix.mergeadaptersample.TeamsTitleAdapter
import com.skanderjabouzi.simplerecyclerview.R
import kotlinx.android.synthetic.main.activity_teams.*
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

class TeamsActivity : AppCompatActivity() {

    private lateinit var playersAdapter: PlayersAdapter
    private lateinit var teamsAdapter: TeamsAdapter
    private lateinit var teamsTitleAdapter: TeamsTitleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        val gson = GsonBuilder().create()
        val teams: Teams = gson.fromJson(assets.open("teams.json").bufferedReader().use { it.readText() }, Teams::class.java)
        Log.e("Teams", "${teams.teams}")

        teamsTitleAdapter = TeamsTitleAdapter()
        teamsAdapter = TeamsAdapter()
        teamsAdapter.teams = teams.teams
        teamsAdapter.notifyDataSetChanged()
        teamsAdapter.notifyItemRangeChanged(0, teams.teams.size)
        teamsRecyclerView.scrollToPosition(0)
        teamsRecyclerView.adapter = teamsAdapter
//        teamsRecyclerView.adapter = ConcatAdapter(teamsTitleAdapter, teamsAdapter)
    }
}