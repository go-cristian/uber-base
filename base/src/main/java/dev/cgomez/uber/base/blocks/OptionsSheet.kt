package dev.cgomez.uber.base.blocks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.cgomez.uber.base.R

class OptionsSheet : BottomSheetDialogFragment() {
  companion object {
    private const val TAG = "Bottom Dialog Sheet"
    const val TITLE = "TITLE"
    const val DESCRIPTION = "DESCRIPTION"
    const val BODY = "BODY"
    const val PRIMARY_BUTTON_TEXT = "PRIMARY_BUTTON"
    const val PRIMARY_BUTTON_CALLBACK = "PRIMARY_BUTTON_CALLBACK"
    const val SECONDARY_BUTTON_TEXT = "SECONDARY_BUTTON"
    const val SECONDARY_BUTTON_CALLBACK = "SECONDARY_BUTTON_CALLBACK"
    const val TERTIARY_BUTTON_TEXT = "TERTIARY_BUTTON"
    const val TERTIARY_BUTTON_CALLBACK = "TERTIARY_BUTTON_CALLBACK"

    fun show(
      activity: AppCompatActivity,
      options: Options
    ): OptionsSheet {
      val fragment = OptionsSheet()
      fragment.arguments = options.toBundle()
      fragment.show(activity.supportFragmentManager, TAG)
      return fragment
    }

    fun show(
      activity: FragmentActivity,
      options: Options
    ): OptionsSheet {
      val fragment = OptionsSheet()
      fragment.arguments = options.toBundle()
      fragment.show(activity.supportFragmentManager, TAG)
      return fragment
    }
  }

  private lateinit var title: TextView
  private lateinit var description: TextView
  private lateinit var body: TextView
  private lateinit var primaryButton: Button
  private lateinit var secondaryButton: Button
  private lateinit var tertiaryButton: Button

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.options_sheet, container, false)
    title = view.findViewById(R.id.title)
    description = view.findViewById(R.id.description)
    body = view.findViewById(R.id.body)
    primaryButton = view.findViewById(R.id.primary_button)
    secondaryButton = view.findViewById(R.id.secondary_button)
    tertiaryButton = view.findViewById(R.id.tertiary_button)
    return view
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    arguments?.let {
      title.text = it.getString(TITLE)
      description.text = it.getString(DESCRIPTION)
      body.text = it.getString(BODY)
    }
    arguments.fillButton(primaryButton, PRIMARY_BUTTON_TEXT)
    arguments.fillButton(secondaryButton, SECONDARY_BUTTON_TEXT)
    arguments.fillButton(tertiaryButton, TERTIARY_BUTTON_TEXT)

  }

  private fun Bundle?.fillButton(
    button: Button,
    type: String
  ) {
    this?.let {
      it.getString(type).orEmpty().run {
        if (isBlank()) {
          button.visibility = View.GONE
        } else {
          button.text = this
          it["${type}_CALLBACK"]?.let { function ->
            button.setOnClickListener {
              @Suppress("UNCHECKED_CAST")
              (function as () -> Unit).invoke()
            }
          }
        }
      }
    }
  }

  data class Options(
    val title: String?,
    val description: String?,
    val body: String?,
    val primaryButtonText: String?,
    val primaryButtonCallback: (() -> Unit)?,
    val secondaryButtonText: String?,
    val secondaryButtonCallback: (() -> Unit)?,
    val tertiaryButtonText: String?,
    val tertiaryButtonCallback: (() -> Unit)?,
  ) {

    fun toBundle() = bundleOf(
      TITLE to title,
      DESCRIPTION to description,
      BODY to body,
      PRIMARY_BUTTON_TEXT to primaryButtonText,
      PRIMARY_BUTTON_CALLBACK to primaryButtonCallback,
      SECONDARY_BUTTON_TEXT to secondaryButtonText,
      SECONDARY_BUTTON_CALLBACK to secondaryButtonCallback,
      TERTIARY_BUTTON_TEXT to tertiaryButtonText,
      TERTIARY_BUTTON_CALLBACK to tertiaryButtonCallback,
    )
  }
}
