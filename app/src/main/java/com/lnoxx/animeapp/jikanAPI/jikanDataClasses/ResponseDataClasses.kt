package com.lnoxx.animeapp.jikanAPI.jikanDataClasses

data class AnimeTopResponse(
    val data: List<Anime>,
    val pagination: Pagination
)

data class Anime(
    val mal_id: Int,
    val images: Images,
    val title: String,
    val episodes: Int,
    val status: String,
    val score: Float,
    val rank: Int,
    val synopsis: String,
    val background: String,
    val themes: List<Theme>,
)

data class Images(
    val jpg: ImageType,
)

data class ImageType(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String
)

data class Theme(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class Pagination(
    val last_visible_page: Int,
    val has_next_page: Boolean,
    val items: Items
)

data class Items(
    val count: Int,
    val total: Int,
    val per_page: Int
)

