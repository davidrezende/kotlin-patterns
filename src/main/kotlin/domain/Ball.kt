
data class Ball(
    val color: BallColor,
    val brand: BallBrand,
    val type: BallType
)

enum class BallColor {
    RED,
    GREEN,
    BLUE,
    ORANGE
}

enum class BallBrand {
    NIKE,
    ADIDAS,
    REEBOK,
    PUMA,
    WILSON
}
enum class BallType {
    BASKETBALL,
    FOOTBALL,
    SOCCER,
    TENNIS,
    VOLLEYBALL
}