package fr.alefaux.pollochon.views.splashscreen.callingcodes

import android.view.View
import fr.alefaux.pollochon.GenericAdapter
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.models.CallingCodeRow
import fr.alefaux.pollochon.models.CallingCodeRowType
import kotlinx.android.synthetic.main.view_calling_code_header.view.*
import kotlinx.android.synthetic.main.view_calling_code_item.view.*

class CallingCodesAdapter : GenericAdapter<CallingCodeRow>() {
    override fun getLayoutId(position: Int, obj: CallingCodeRow): Int =
        if(obj.callingCodeRowType == CallingCodeRowType.HEADER) R.layout.view_calling_code_header else R.layout.view_calling_code_item

    override fun getViewHolder(view: View): Binder<CallingCodeRow> = ViewHolder(view)

    class ViewHolder(itemView: View) : Binder<CallingCodeRow>(itemView) {

        override fun bind(data: CallingCodeRow, position: Int): Unit = if(data.callingCodeRowType == CallingCodeRowType.HEADER) {
            with(itemView) {
                tv_calling_code_state.text = "${data.callingCode.translations.french} (+${data.callingCode.callingCodes.firstOrNull()})"
            }
        } else {
            with(itemView) {
                tv_calling_code_header.text = data.headerTitle
            }
        }

    }
}