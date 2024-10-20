package com.jamie.newsapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.jamie.newsapp.R
import com.jamie.newsapp.domain.model.Article
import com.jamie.newsapp.presentation.Dimens.ExtraSmallPadding
import com.jamie.newsapp.presentation.Dimens.MediumPadding1
import com.jamie.newsapp.presentation.common.ArticlesList
import com.jamie.newsapp.presentation.common.SearchBar
import com.jamie.newsapp.presentation.navgraph.Route

@Composable
fun HomeScreen(modifier: Modifier = Modifier, articles: LazyPagingItems<Article>, navigate: (route: String) -> Unit) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " 🔴 ") { it.title }
            } else {
                ""
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo1),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Box(modifier= Modifier.padding(horizontal = 10.dp)) {
            SearchBar(
                text = "",
                readOnly = true,
                onValueChange = {},
                onClick = { navigate(Route.SearchScreen.route) },
                onSearch = {})
        }
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        ArticlesList(
            modifier = Modifier.padding(horizontal = ExtraSmallPadding),
            articles = articles,
            onClick = { navigate(Route.DetailsScreen.route) })
    }
}