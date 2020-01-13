package com.revolut.currencyconverter.views.adapters

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.revolut.currencyconverter.R
import com.revolut.currencyconverter.network.model.CurrencyViewerModel
import kotlinx.android.synthetic.main.layout_currency.view.*

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var currencyList = ArrayList<CurrencyViewerModel>()
    private var onValueChange: ((model: CurrencyViewerModel, Float) -> Unit)? = null
    private var onPositionChange: ((CurrencyViewerModel) -> Unit)? = null
    var defaultAmount = 1.0F

    private val textChange = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val model = currencyList[0]
            defaultAmount = s.toString().toFloat()
            onValueChange?.invoke(model, defaultAmount)
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_currency, parent, false))
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencyList[position], position)
    }

    fun setList(currencyList: ArrayList<CurrencyViewerModel>) {
        this.currencyList = currencyList
        notifyDataSetChanged()
    }

    fun updateDefaultAmount(defaultAmount: Float) {
        this.defaultAmount = defaultAmount
        notifyItemRangeChanged(0, currencyList.size - 1, defaultAmount)
    }

    fun onValueChangeListener(onValueChange: ((CurrencyViewerModel, Float) -> Unit)) {
        this.onValueChange = onValueChange
    }

    fun onPositionChangeListener(onPositionChange: ((CurrencyViewerModel) -> Unit)) {
        this.onPositionChange = onPositionChange
    }

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: CurrencyViewerModel, position: Int) {
            itemView.ivFlag.setImageResource(model.flag)
            itemView.tvCurrencyCode.text = model.currencyCode.name
            itemView.tvCurrencyName.text = model.currencyName
            val calculatedVal = model.value * defaultAmount
            itemView.etValue.imeOptions = EditorInfo.IME_ACTION_DONE

            itemView.etValue.removeTextChangedListener(textChange)
            itemView.etValue.setText(calculatedVal.toString())
            itemView.etValue.addTextChangedListener(textChange)
            itemView.etValue.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                layoutPosition.takeIf { it > 0 }?.also { currentPosition ->
                    currencyList.removeAt(currentPosition).also {
                        currencyList.add(0, it)
                        onPositionChange?.invoke(model)
                    }
                    notifyItemMoved(currentPosition, 0)
                }
            }
        }
    }
}
