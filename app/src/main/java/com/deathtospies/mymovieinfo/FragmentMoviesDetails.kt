package com.deathtospies.mymovieinfo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesDetails : Fragment() {
    private var FragmentMoviesDetailsClickListener: FragmentMoviesDetailsClickListener? = null
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)

        view?.findViewById<ImageView>(R.id.back_icon)?.apply {
            setOnClickListener {
                FragmentMoviesDetailsClickListener?.OnBackNavigationClicked()
            }
        }

        view?.findViewById<TextView>(R.id.back_text_view)?.apply {
            setOnClickListener {
                FragmentMoviesDetailsClickListener?.OnBackNavigationClicked()
            }
        }

        return view
    }

    companion object {
        /**
         * @return A new instance of fragment MoviesDetailsFragment.
         */
        @JvmStatic
        fun newInstance(): FragmentMoviesDetails {
                return FragmentMoviesDetails()
                }
            }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesDetailsClickListener) {
            FragmentMoviesDetailsClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        FragmentMoviesDetailsClickListener = null
    }
}


interface FragmentMoviesDetailsClickListener {
    fun OnBackNavigationClicked()
}
