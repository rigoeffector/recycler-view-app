import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclercompose.R
import com.example.recyclercompose.models.DataModel
import com.example.recyclercompose.ui.theme.ampersand
import java.util.*

@Composable
fun ListViewScreen(
    items: List<DataModel>,
    onItemClick: (DataModel) -> Unit,
    isLoading: Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), style = MaterialTheme.typography.h5, color = ampersand) },
            )
        }
    ) {
        LazyColumn {
            items(items) { item ->
                ListItem(item, onItemClick)
            }
            if (isLoading) {
                item {
                    LoadingIndicator()
                }
            }
        }
    }

}

@Composable
fun ListItem(item: DataModel, onItemClick: (DataModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClick(item) },
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.surface, // Optional: Set background color
        shape = MaterialTheme.shapes.medium // Optional: Set shape (rounded corners)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colors.primary)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.name.take(1).uppercase(),
                    color = ampersand,
                    fontSize = 24.sp,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.name, style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.height(4.dp))

            }
        }
    }
}



@Composable
fun LoadingIndicator() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.primary, // Adjust color as needed
            strokeWidth = 4.dp
        )
    }
}
