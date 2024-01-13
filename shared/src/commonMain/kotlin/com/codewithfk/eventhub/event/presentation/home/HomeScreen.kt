package com.codewithfk.eventhub.event.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithfk.eventhub.di.AppModule
import com.codewithfk.eventhub.event.domain.model.Event
import com.codewithfk.eventhub.theme.accent1
import com.codewithfk.eventhub.theme.accent2
import com.codewithfk.eventhub.theme.accent3
import com.codewithfk.eventhub.theme.accent4
import com.codewithfk.goodnight.MR
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.ImageResource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun HomeScreen(appModule: AppModule, navigator: Navigator) {
    val viewModel = getViewModel(key = "home", factory = viewModelFactory { HomeViewModel() })
    HomeScreenInternal(navigator, viewModel)
}

@Composable
fun HomeScreenInternal(navigator: Navigator, viewModel: HomeViewModel) {

    val density = LocalDensity.current
    val columnHeight = remember { mutableStateOf(0.dp) }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(Color.Blue)
                    .padding(16.dp)
                    .onGloballyPositioned {
                        columnHeight.value = with(density) { it.size.height.toDp() + 12.dp }
                    }
            ) {
                ActionBarRow()
                Spacer(modifier = Modifier.size(16.dp))
                SearchBarRow()
                Spacer(modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.size(32.dp))
            val state = viewModel.state.collectAsState()
            when (state.value) {
                is HomeViewStates.Loading -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(48.dp))
                        Text(text = "Loading")
                    }

                }

                is HomeViewStates.Success -> {
                    val result = (state.value as HomeViewStates.Success).response

                    LazyRow {
                        items(result) { event ->
                            EventItem(event, onClick = {
                                //navigator.navigate(NavRouts.EventDetails.path(event))
                            })
                        }
                    }
                }

                else -> {
                    Text(text = "Error")
                }
            }
        }

        Row(
            modifier = Modifier.padding(top = columnHeight.value)
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Category("Sports", MR.images.ic_sports, accent1)
            Category("Music", MR.images.ic_music, accent2)
            Category("Food", MR.images.ic_food, accent3)
            Category("Game", MR.images.game, accent4)
            Category("Art", MR.images.art, accent1)
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
fun ActionBarRow() {
    Box(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Image(
            painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_menu),
            contentDescription = "Menu",
            modifier = Modifier.align(Alignment.CenterStart)
                .size(32.dp)
                .padding(8.dp)
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Current Location",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = (0.8f))
            )
            Text(
                text = "New York, USA",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
        Image(
            painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_notification),
            contentDescription = "notification",
            modifier = Modifier.align(Alignment.CenterEnd).size(32.dp)
        )
    }
}

@Composable
fun SearchBarRow() {
    val text = remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(5f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(32.dp).padding(4.dp)
            )
            val color =
                MaterialTheme.colorScheme.onPrimary.copy(alpha = (0.8f))
            TextField(
                value = text.value,
                onValueChange = { text.value = it },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = color,
                    unfocusedTextColor = color,
                    focusedPlaceholderColor = color,
                    unfocusedPlaceholderColor = color,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = color,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedLabelColor = color,
                    unfocusedLabelColor = color
                ),
                label = { Text("Search...") },
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().weight(2f)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = (0.1f)))
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_filter),
                contentDescription = "Filter",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "Filter", fontSize = 14.sp, color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}

@Composable
fun GoingItem() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box {
            Row {
                Spacer(modifier = Modifier.size(40.dp))
                Image(
                    painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_image),
                    contentDescription = "Image",
                    modifier = Modifier.size(40.dp)
                )
            }
            Row {
                Spacer(modifier = Modifier.size(20.dp))
                Image(
                    painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_image1),
                    contentDescription = "Image",
                    modifier = Modifier.size(40.dp)
                )
            }
            Row {
                Image(
                    painter = dev.icerock.moko.resources.compose.painterResource(MR.images.ic_image2),
                    contentDescription = "Image",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "20+ Going", fontSize = 16.sp, color = Color.Blue)
    }
}

@Composable
fun EventItem(event: Event, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp, 25.dp)
    ) {
        Column(modifier = Modifier.width(237.dp).padding(16.dp)) {
            EventImageSection(event = event)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = event.name ?: "",
                fontSize = 18.sp,
                modifier = Modifier.padding(16.dp),
                maxLines = 1
            )
            GoingItem()
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = dev.icerock.moko.resources.compose.painterResource(MR.images.pin),
                    contentDescription = "location"
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = event._embedded?.venues?.getOrNull(0)?.address?.line1 ?: "",
                    fontSize = 14.sp,
                    color = Color.Gray.copy(alpha = 0.8f),
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun EventImageSection(event: Event) {
    Box(modifier = Modifier.fillMaxWidth()) {
        KamelImage(
            resource = asyncPainterResource(event.images?.find { it.ratio == "16_9" }?.url!!),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .aspectRatio(1.7f, matchHeightConstraintsFirst = true),
            contentDescription = null
        )
        Column(
            modifier = Modifier.align(Alignment.TopStart).clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)).padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "10", fontSize = 24.sp, color = Color.Red.copy(alpha = 0.8f))
            Text(text = "Jan", fontSize = 16.sp, color = Color.Red.copy(alpha = 0.8f))
        }

        Image(
            painter = dev.icerock.moko.resources.compose.painterResource(MR.images.saved),
            contentDescription = "saved",
            modifier = Modifier.padding(16.dp).align(Alignment.TopEnd)
        )
    }
}

@Composable
fun Category(title: String, res: ImageResource, color: Color) {
    Spacer(modifier = Modifier.size(4.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(color)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
    {
        Image(
            painter = dev.icerock.moko.resources.compose.painterResource(res),
            contentDescription = "Image",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = title, fontSize = 14.sp, color = Color.White)
    }

}