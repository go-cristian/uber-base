package dev.cgomez.uber.app

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import dev.cgomez.oldkase.annotations.WidgetComponent
import dev.cgomez.uber.base.blocks.Grid
import dev.cgomez.uber.base.blocks.ItemList
import dev.cgomez.uber.base.blocks.OptionsSheet

val colors = listOf(
  "purple",
  "cobalt",
  "blue",
  "green",
  "yellow",
  "orange",
  "red",
  "brown",
  "gray",
  "platinum",
)
val weights = listOf(700, 600, 500, 400, 300, 200, 100, 50)

val allCompound = colors.map { color -> weights.map { "${color}_${it}" } }.flatten()

val foundationColors = listOf(
  Pair("primary_a", "black"),
  Pair("primary_a", "black"),
  Pair("primary_b", "white"),
  Pair("accent", "blue_400"),
  Pair("negative", "red_400"),
  Pair("warning", "yellow_400"),
  Pair("positive", "green_400"),
)

val coreBackgroundColors = listOf(
  Pair("background_primary", "primary_b"),
  Pair("background_secondary", "gray_50"),
  Pair("background_tertiary", "gray_100"),
  Pair("background_inverse_primary", "primary_a"),
  Pair("background_inverse_secondary", "gray_800"),
)

val coreContentColors = listOf(
  Pair("content_primary", "primary_a"),
  Pair("content_secondary", "gray_600"),
  Pair("content_tertiary", "gray_500"),
  Pair("content_inverse_primary", "primary_b"),
  Pair("content_inverse_secondary", "gray_300"),
  Pair("content_inverse_tertiary", "gray_400"),
)

val coreBorderColors = listOf(
  Pair("border_opaque", "gray_200"),
  Pair("border_transparent", "primary_a_p08"),
  Pair("border_selected", "primary_a"),
  Pair("border_inverse_opaque", "gray_700"),
  Pair("border_inverse_transparent", "primary_b_p20"),
  Pair("border_inverse_selected", "primary_b"),
)

val coreExtensionsBackgroundColors = listOf(
  Pair("background_state_disabled", "gray_50"),
  Pair("background_overlay_dark", "black_p30"),
  Pair("background_overlay_light", "black_p08"),
  Pair("background_accent", "accent"),
  Pair("background_negative", "negative"),
  Pair("background_warning", "warning"),
  Pair("background_positive", "positive"),
  Pair("background_light_accent", "blue_50"),
  Pair("background_light_negative", "red_50"),
  Pair("background_light_warning", "yellow_50"),
  Pair("background_light_positive", "green_50"),
  Pair("background_always_dark", "black"),
  Pair("background_always_light", "white"),
)

val coreExtensionsContentColors = listOf(
  Pair("content_state_disabled", "gray_400"),
  Pair("content_on_color", "white"),
  Pair("content_accent", "blue_400"),
  Pair("content_negative", "red_400"),
  Pair("content_warning", "yellow_500"),
  Pair("content_positive", "gray_400"),
)

val coreExtensionsBorderColors = listOf(
  Pair("border_state_disabled", "green_50"),
  Pair("border_accent", "blue_400"),
  Pair("border_accent_light", "blue_200"),
  Pair("border_negative", "red_200"),
  Pair("border_warning", "yellow_200"),
  Pair("border_positive", "gray_200"),
)

@WidgetComponent("01 Primitives")
fun primitives(
  parent: ViewGroup,
  activity: FragmentActivity
): View {
  val layout = parent.viewFrom(R.layout.grid)
  val grid = layout.findViewById<Grid>(R.id.grid)
  val buildView = { view: ViewGroup -> view.viewFrom(R.layout.icon) }
  val bindView = { view: View, color: String ->
    val title = view.findViewById<TextView>(R.id.title)
    val subtitle = view.findViewById<TextView>(R.id.subtitle)
    view.setBackgroundColor(parent.context.colorFromName(color))
    title.text = color
    subtitle.text = parent.context.colorHexa(color)
    view.setOnClickListener { println(color) }
  }
  grid.init(allCompound, buildView, bindView)
  return grid
}

@WidgetComponent("02 Foundation")
fun foundation(
  parent: ViewGroup,
  activity: FragmentActivity
): View = list(parent, foundationColors)

@WidgetComponent("03 Core/Background")
fun coreBackground(
  parent: ViewGroup,
  activity: FragmentActivity
): View = list(parent, coreBackgroundColors)

@WidgetComponent("03 Core/Content")
fun coreContent(
  parent: ViewGroup,
  activity: FragmentActivity
): View = list(parent, coreContentColors)

@WidgetComponent("03 Core/Border")
fun coreBorder(
  parent: ViewGroup,
  activity: FragmentActivity
): View = list(parent, coreBorderColors)

@WidgetComponent("03 Core/Extensions/Background")
fun coreExtensionsBackgroundColors(
  parent: ViewGroup,
  activity: FragmentActivity
): View =
  list(parent, coreExtensionsBackgroundColors)

@WidgetComponent("03 Core/Extensions/Content")
fun coreExtensionsContentColors(
  parent: ViewGroup,
  activity: FragmentActivity
): View =
  list(parent, coreExtensionsContentColors)

@WidgetComponent("03 Core/Extensions/Border")
fun coreExtensionsBorderColors(
  parent: ViewGroup,
  activity: FragmentActivity
): View =
  list(parent, coreExtensionsBorderColors)

@WidgetComponent("Typography/Display")
fun typographyDisplay(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.typography_display)

@WidgetComponent("Typography/Heading")
fun typographyHeading(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.typography_heading)

@WidgetComponent("Typography/Label")
fun typographyLabel(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.typography_label)

@WidgetComponent("Typography/Paragraph")
fun typographyParagraph(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.typography_paragraph)

@WidgetComponent("Buttons")
fun buttons(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.buttons)

@WidgetComponent("Button/Square")
fun squareButtons(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.button_square)

@WidgetComponent("Button/Circle")
fun circleButtons(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.button_circle)

@WidgetComponent("Progress Bars")
fun progressBars(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.progress)

@WidgetComponent("Sheet Header")
fun sheetHeader(
  parent: ViewGroup,
  activity: FragmentActivity
): View = parent.viewFrom(R.layout.sheet_header)

@WidgetComponent("Bottom Sheet")
fun bottomSheet(
  parent: ViewGroup,
  activity: FragmentActivity
): View {
  val view = parent.viewFrom(R.layout.button_layout)
  val button = view.findViewById<View>(R.id.button)
  val options = OptionsSheet.Options(
    title = "title",
    description = "description",
    body = "body",
    primaryButtonText = "Accept",
    primaryButtonCallback = { Log.d("Clicked", "primaryButtonText") },
    secondaryButtonText = "Cancel",
    secondaryButtonCallback = { Log.d("Clicked", "secondaryButtonText") },
    tertiaryButtonText = "Decline",
    tertiaryButtonCallback = { Log.d("Clicked", "tertiaryButtonText") },
  )
  button.setOnClickListener { OptionsSheet.show(activity, options) }
  return view
}

private fun list(
  parent: ViewGroup,
  colors: List<Pair<String, String>>
): View {
  val layout = parent.viewFrom(R.layout.list)
  val list = layout.findViewById<ItemList>(R.id.list)
  val buildView = { view: ViewGroup -> view.viewFrom(R.layout.foundation_cell) }
  list.init(colors, buildView) { view, color ->
    val colorView = view.findViewById<View>(R.id.color)
    val labelView = view.findViewById<TextView>(R.id.label)
    val paragraphView = view.findViewById<TextView>(R.id.paragraph)
    colorView.setBackgroundColor(parent.context.colorFromName(color.first))
    labelView.text = color.first
    paragraphView.text = color.second
    view.setOnClickListener { println(color) }
  }
  return list
}
