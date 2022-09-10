package com.codebaron.domain.models.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class Result(
    @ColumnInfo(name = "adult") val adult: Boolean? = null,
    @ColumnInfo(name = "backdrop_path") val backdrop_path: String? = null,
    @ColumnInfo(name = "first_air_date") val first_air_date: String? = null,
    @ColumnInfo(name = "genre_ids") val genre_ids: List<Int>? = null,
    @PrimaryKey @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "media_type") val media_type: String? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "origin_country") val origin_country: List<String>? = null,
    @ColumnInfo(name = "original_language") val original_language: String? = null,
    @ColumnInfo(name = "original_name") val original_name: String? = null,
    @ColumnInfo(name = "original_title") val original_title: String? = null,
    @ColumnInfo(name = "overview") val overview: String? = null,
    @ColumnInfo(name = "popularity") val popularity: Double? = null,
    @ColumnInfo(name = "poster_path") val poster_path: String? = null,
    @ColumnInfo(name = "release_date") val release_date: String? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "video") val video: Boolean? = null,
    @ColumnInfo(name = "vote_average") val vote_average: Double? = null,
    @ColumnInfo(name = "vote_count") val vote_count: Int? = null
)

val trendingResultDummy = listOf(
    Result(
        adult = false,
        backdrop_path = "/56v2KjBlU4XaOv9rVYEQypROD7P.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "Stranger Things",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "Stranger Things",
        original_title = "Stranger Things",
        overview = "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.",
        popularity = 4790.722,
        poster_path = "/49WJfeN0moxb9IPfGn8AIqMGskD.jpg",
        release_date = "2016-07-15",
        title = "Stranger Things",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/yQTQL9pliY6vpRt8HkjUJrKymBb.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "The Terminal List",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "The Terminal List",
        original_title = "The Terminal List",
        overview = "The Terminal List, Navy SEAL Commander James Reece turns to vengeance as he investigates the mysterious forces behind the murder of his entire platoon. Free from the military’s command structure, Reece applies the lessons he’s learned from nearly two decades of warfare to hunt down the people responsible.",
        popularity = 4790.722,
        poster_path = "/ujVz6YZxBkDsw3wanO2AKhl3A9y.jpg",
        release_date = "2016-07-15",
        title = "The Terminal List",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/5PnypKiSj2efSPqThNjTXz8jwOg.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "A beautiful",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "A beautiful",
        original_title = "A beautiful",
        overview = "A beautiful, strong-willed young royal refuses to wed the cruel sociopath to whom she is betrothed and is kidnapped and locked in a remote tower of her father’s castle. With her scorned, vindictive suitor intent on taking her father’s throne, the princess must protect her family and save the kingdom.",
        popularity = 4790.722,
        poster_path = "/gt9s8TtZZ36TXF1CE1y19rSpOZu.jpg",
        release_date = "2016-07-15",
        title = "A beautiful",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "Doctor Strange",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "Doctor Strange",
        original_title = "Doctor Strange in the Multiverse of Madness",
        overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
        popularity = 4790.722,
        poster_path = "/61PVJ06oecwvcBisoAQu6SDfdcS.jpg",
        release_date = "2016-07-15",
        title = "Doctor Strange",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/90ez6ArvpO8bvpyIngBuwXOqJm5.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "दिलवाले दुल्हनिया ले जायेंगे",
        origin_country = listOf("HI"),
        original_language = "en",
        original_name = "दिलवाले दुल्हनिया ले जायेंगे",
        original_title = "Dilwale Dulhania Le Jayenge",
        overview = "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
        popularity = 4790.722,
        poster_path = "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
        release_date = "2016-07-15",
        title = "दिलवाले दुल्हनिया ले जायेंगे",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/4BlS2ojR7ueEYsBUNi6reY4livW.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "Baymax!",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "Baymax!",
        original_title = "Baymax!",
        overview = "Return to the fantastical city of San Fransokyo where the affable, inflatable, inimitable healthcare companion robot, Baymax, sets out to do what he was programmed to do: help others.",
        popularity = 4790.722,
        poster_path = "/muzgYvvFniQnwiTdAvfMCEkHsT4.jpg",
        release_date = "2016-07-15",
        title = "Baymax!",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/n6vVs6z8obNbExdD3QHTr4Utu1Z.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "Stranger Things",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "The Boys",
        original_title = "The Boys",
        overview = "The Boys, A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
        popularity = 4790.722,
        poster_path = "/stTEycfG9928HYGEISBFaG1ngjM.jpg",
        release_date = "2016-07-15",
        title = "The Boys",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    ),
    Result(
        adult = false,
        backdrop_path = "/bszpg7dIDSap4hrJHMBk1NgpqHg.jpg",
        first_air_date = "2016-07-15",
        genre_ids = listOf(18, 10765, 9648),
        id = 66732,
        media_type = "tv",
        name = "Code Name Banshee",
        origin_country = listOf("US"),
        original_language = "en",
        original_name = "Code Name Banshee",
        original_title = "Code Name Banshee",
        overview = "Caleb, a former government assassin in hiding, who resurfaces when his protégé, the equally deadly killer known as Banshee, discovers a bounty has been placed on Caleb's head.",
        popularity = 4790.722,
        poster_path = "/lxkvlIrvExeHGiPk7bdji2xm3vs.jpg",
        release_date = "2016-07-15",
        title = "Code Name Banshee",
        video = false,
        vote_average = 8.6,
        vote_count = 11484
    )
)