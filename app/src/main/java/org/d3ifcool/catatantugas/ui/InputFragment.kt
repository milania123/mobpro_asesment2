package org.d3ifcool.catatantugas.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3ifcool.catatantugas.R
import org.d3ifcool.catatantugas.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentInputBinding.inflate(
            layoutInflater, container, false)
        binding.btmMasuk.setOnClickListener { masukData() }
        return binding.root
    }

    @SuppressLint("StringFormatInvalid")
    private fun masukData() {
        val nama = binding.namaTugas.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(context, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val deadline = binding.dateTugas.text.toString()
        if (TextUtils.isEmpty(deadline)){
            Toast.makeText(context, R.string.dateline_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val catatan = binding.catatan.text.toString()
        if (TextUtils.isEmpty(catatan)){
            Toast.makeText(context, R.string.catatan_invalid, Toast.LENGTH_LONG).show()
            return
        }

        Toast.makeText(context, R.string.simpan, Toast.LENGTH_SHORT).show()

        binding.txtTugas.text = getString(R.string.textnama, nama)
        binding.txtDate.text = getString(R.string.textDeadline, deadline)
        binding.txtCatatan.text = getString(R.string.textCatn, catatan)

    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
                binding.namaTugas.text,
                binding.dateTugas.text,
                binding.catatan.text)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    private fun reset() {
        binding.namaTugas.text.isEmpty()
        binding.dateTugas.text.isEmpty()
        binding.catatan.text.isEmpty()
    }


}