package com.clipperengine.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Subtitles
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val Bg = Color(0xFF10120B)
private val Panel = Color(0xFF20241A)
private val Lime = Color(0xFFD2FF45)
private val Muted = Color(0xFFABB39B)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ClipperHome() }
    }
}


@Composable
fun ClipperHome() {
    val context = LocalContext.current
    MaterialTheme(colorScheme = darkColorScheme(background = Bg, surface = Panel, primary = Lime)) {
        Scaffold(containerColor = Bg) { pad ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(pad).padding(horizontal = 18.dp),
                contentPadding = PaddingValues(top = 20.dp, bottom = 30.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text("CLIPPER ENGINE", color = Lime, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
                    Text("GTA 6 live stream moments", color = Muted, style = MaterialTheme.typography.bodyMedium)
                }
                item {
                    Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(20.dp)) {
                        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.LiveTv, contentDescription = null, tint = Lime)
                                Spacer(Modifier.width(8.dp))
                                Text("STREAM DASHBOARD", fontWeight = FontWeight.Bold, color = Color.White)
                            }
                            Text("Find live GTA 6 streams across Twitch, YouTube and Kick.", color = Muted)
                            Button(
                                onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://clipperengine.vercel.app"))) },
                                colors = ButtonDefaults.buttonColors(containerColor = Lime, contentColor = Color.Black),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(Icons.Default.OpenInBrowser, contentDescription = null)
                                Spacer(Modifier.width(8.dp))
                                Text("Open live preview")
                            }
                        }
                    }
                }
                item { FeatureCard(Icons.Default.PlayArrow, "AUTO CLIPPER", "Mobile recording and hype detection — engine not connected yet.") }
                item { FeatureCard(Icons.Default.Movie, "VIDEO GARAGE", "Clip review, trim controls and 9:16 / widescreen export — coming in the port.") }
                item { FeatureCard(Icons.Default.Subtitles, "CAPTIONS", "Caption generation and export integration is a later development step.") }
                item {
                    Text("Android port starter · v0.1", color = Muted, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}


@Composable
fun FeatureCard(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, description: String) {
    Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(20.dp)) {
        Row(Modifier.padding(18.dp), verticalAlignment = Alignment.Top) {
            Icon(icon, contentDescription = null, tint = Lime, modifier = Modifier.size(28.dp))
            Spacer(Modifier.width(12.dp))
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(description, color = Muted, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
