package com.codewithfk.eventhub.event.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codewithfk.eventhub.di.AppModule
import com.codewithfk.eventhub.event.domain.model.EventModel
import com.codewithfk.eventhub.event.domain.remote.EventService
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun HomeScreen(appModule: AppModule, navigator: Navigator) {
    var service = EventService.create()
    val eventState = produceState<List<EventModel>>(
        initialValue = emptyList(),
        producer = {
            value = service.getEvents()
        }
    )
    LazyColumn {
        items(eventState.value) { event ->
            Text(text = event.title, modifier = Modifier.padding(8.dp))
        }
    }
}