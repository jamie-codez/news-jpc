package com.jamie.newsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.jamie.newsapp.R
import com.jamie.newsapp.domain.model.Article
import com.jamie.newsapp.domain.model.Source
import com.jamie.newsapp.presentation.Dimens.ArticleCardSize
import com.jamie.newsapp.presentation.Dimens.ExtraSmallPadding
import com.jamie.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.jamie.newsapp.presentation.Dimens.SmallIconSize
import com.jamie.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current
//    Card(
//        modifier = modifier
//            .padding(start = 2.dp, end = 2.dp, top = 1.dp)
//            .fillMaxWidth(),
//        shape = MaterialTheme.shapes.medium,
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
        Row(modifier = modifier.clickable { onClick() }) {
            AsyncImage(
                modifier = Modifier
                    .height(ArticleCardSize)
                    .size(ArticleCardSize)
                    .padding(start = 1.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(article.urlToImage).size(Size.ORIGINAL).build(),
                contentDescription = article.title
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = ExtraSmallPadding)
                    .height(ArticleCardSize)
                    .padding(top = 5.dp, bottom = 5.dp)
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.text_title),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                ) {
                    Text(
                        text = article.source.name,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body),
                        modifier = Modifier
                            .border(width = 0.5.dp, color = Color.LightGray, shape = CircleShape)
                            .clip(
                                CircleShape
                            )
                            .padding(start = 4.dp, end = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    Icon(
                        painter = painterResource(id = R.drawable.time),
                        contentDescription = null,
                        modifier = Modifier.size(SmallIconSize),
                        tint = colorResource(R.color.body)
                    )
                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    Text(
                        text = article.publishedAt,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body),
                    )
                }
            }
        }
//    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And her savior came swooping in like a knight in shinning armor. Oh what a day it was.",
                url = "",
                urlToImage = ""
            )
        ) { }
    }
}