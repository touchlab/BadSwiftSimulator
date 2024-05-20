package co.touchlab.sdk

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

private val fortunes = listOf(
    "Good things come to those who wait, but better things come to those who take action.",
    "Your kindness will lead you to success.",
    "A smile is your passport into the hearts of others.",
    "Your talents will be recognized and rewarded.",
    "The best way to predict the future is to create it.",
    "Opportunities are everywhere, all it takes is the right mindset to see them.",
    "Adventure awaits you at every corner.",
    "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
    "You will soon embark on a journey that will change your life.",
    "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful."
)

class FortuneTeller {

suspend fun getFortune(): String {
    lateinit var fortuneToReturn: String
    return try {
        withContext(NonCancellable) {
            delay(2.seconds)
            fortuneToReturn = fortunes.random()
        }

        fortuneToReturn
    } catch (e: CancellationException) {
        fortuneToReturn
    }
}
}
