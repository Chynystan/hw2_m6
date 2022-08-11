package com.geektech.hw2_m6

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

object PromptUtils {
    fun alertDialog(context: Context, dialogBuilder: AlertDialog.Builder.() -> Unit): Dialog {
        val builder = AlertDialog.Builder(context).also {
            it.setCancelable(false)
            it.dialogBuilder()
        }
        return builder.create()
    }

    fun AlertDialog.Builder.negativeButton(text: String = "No",
                                           handleClick: (dialogInterface: DialogInterface)
                                           -> Unit = {}) {
        this.setPositiveButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
    }

    fun AlertDialog.Builder.positiveButton(text: String = "Yes",
                                           handleClick: (dialogInterface: DialogInterface)
                                           -> Unit = {}) {
        this.setNegativeButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
    }
}