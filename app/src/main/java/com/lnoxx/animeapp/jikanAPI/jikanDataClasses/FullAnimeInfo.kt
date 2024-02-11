package com.lnoxx.animeapp.jikanAPI.jikanDataClasses

data class AnimeDataResponse(
    val mal_id: Int,
    val url: String,
    val images: ImagesResponse,
    val trailer: TrailerResponse,
    val approved: Boolean,
    val titles: List<TitleResponse>,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val title_synonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Int,
    val status: String,
    val airing: Boolean,
    val aired: AiredResponse,
    val duration: String,
    val rating: String,
    val score: Int,
    val scored_by: Int,
    val rank: Int,
    val popularity: Int,
    val members: Int,
    val favorites: Int,
    val synopsis: String,
    val background: String,
    val season: String,
    val year: Int,
    val broadcast: BroadcastResponse,
    val producers: List<ProducerResponse>,
    val licensors: List<LicensorResponse>,
    val studios: List<StudioResponse>,
    val genres: List<GenreResponse>,
    val explicit_genres: List<GenreResponse>,
    val themes: List<ThemeResponse>,
    val demographics: List<DemographicResponse>,
    val relations: List<RelationResponse>,
    val theme: ThemeResponse,
    val external: List<ExternalResponse>,
    val streaming: List<StreamingResponse>
)

data class ImagesResponse(
    val jpg: ImageTypeResponse,
    val webp: ImageTypeResponse
)

data class ImageTypeResponse(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String
)

data class TrailerResponse(
    val youtube_id: String,
    val url: String,
    val embed_url: String
)

data class TitleResponse(
    val type: String,
    val title: String
)

data class AiredResponse(
    val from: String,
    val to: String,
    val prop: AiredPropResponse
)

data class AiredPropResponse(
    val from: AiredDateResponse,
    val to: AiredDateResponse,
    val string: String
)

data class AiredDateResponse(
    val day: Int,
    val month: Int,
    val year: Int
)

data class BroadcastResponse(
    val day: String,
    val time: String,
    val timezone: String,
    val string: String
)

data class ProducerResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class LicensorResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class StudioResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class GenreResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class ThemeResponse(
    val openings: List<String>,
    val endings: List<String>
)

data class DemographicResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class RelationResponse(
    val relation: String,
    val entry: List<EntryResponse>
)

data class EntryResponse(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)

data class ExternalResponse(
    val name: String,
    val url: String
)

data class StreamingResponse(
    val name: String,
    val url: String
)
