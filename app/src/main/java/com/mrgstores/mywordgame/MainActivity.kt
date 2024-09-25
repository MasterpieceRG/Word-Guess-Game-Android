package com.mrgstores.mywordgame

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.mrgstores.mywordgame.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val questions = arrayOf(
            "What animal says meow?",
            "Which animal has stripes and runs fast?",
            "Which bird has beautiful feathers and can swim?",
            "Which tiny insect can build anthills?",
            "What animal is small, can squeak, and loves cheese?"
        )
        val answerImages =
            arrayOf(
                R.drawable.cat,
                R.drawable.tiger,
                R.drawable.duck,
                R.drawable.ant,
                R.drawable.mouse
            )
        val answers = arrayOf("CAT", "TIGER", "DUCK", "ANT", "MOUSE")
        val answerSuggestions = arrayOf("APCJOLT", "IGAORTJKE", "ECDVUEKO", "EAMTWNX", "QNMAEDUSO")

        var counter = 0

        binding.questionTxt.text = questions[counter]
        binding.answerImage.setImageResource(answerImages[counter])
        var answersChar = answers[counter].toCharArray()
        var answerSuggestionsChar = answerSuggestions[counter].toCharArray()

        when (answersChar.size) {
            3 -> {
                val firstChar = answersChar[0]
                val secondChar = answersChar[1]
                val thirdChar = answersChar[2]

                binding.dash1.visibility = View.VISIBLE
                binding.letter1.text = firstChar.toString()
                binding.dash2.visibility = View.VISIBLE
                binding.letter2.text = secondChar.toString()
                binding.dash3.visibility = View.VISIBLE
                binding.letter3.text = thirdChar.toString()

                binding.dash4.visibility = View.GONE
                binding.dash5.visibility = View.GONE

                binding.sWordLayout1.visibility = View.VISIBLE
                binding.sWordLayout2.visibility = View.VISIBLE
                binding.sWordLayout3.visibility = View.VISIBLE
                binding.sWordLayout4.visibility = View.VISIBLE
                binding.sWordLayout6.visibility = View.VISIBLE
                binding.sWordLayout7.visibility = View.VISIBLE
                binding.sWordLayout8.visibility = View.VISIBLE

                binding.sWord1.text = answerSuggestionsChar[0].toString()
                binding.sWord2.text = answerSuggestionsChar[1].toString()
                binding.sWord3.text = answerSuggestionsChar[2].toString()
                binding.sWord4.text = answerSuggestionsChar[3].toString()
                binding.sWord6.text = answerSuggestionsChar[4].toString()
                binding.sWord7.text = answerSuggestionsChar[5].toString()
                binding.sWord8.text = answerSuggestionsChar[6].toString()

                binding.sWordLayout1.setOnClickListener {
                    if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout1.isEnabled = false
                }

                binding.sWordLayout2.setOnClickListener {
                    if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout2.isEnabled = false
                }

                binding.sWordLayout3.setOnClickListener {
                    if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout3.isEnabled = false
                }

                binding.sWordLayout4.setOnClickListener {
                    if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout4.isEnabled = false
                }

                binding.sWordLayout5.visibility = View.GONE

                binding.sWordLayout6.setOnClickListener {
                    if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout6.isEnabled = false
                }

                binding.sWordLayout7.setOnClickListener {
                    if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout7.isEnabled = false
                }

                binding.sWordLayout8.setOnClickListener {
                    if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout8.isEnabled = false
                }

                binding.sWordLayout9.visibility = View.GONE
            }
            4 -> {
                val firstChar = answersChar[0]
                val secondChar = answersChar[1]
                val thirdChar = answersChar[2]
                val fourthChar = answersChar[3]

                binding.dash1.visibility = View.VISIBLE
                binding.letter1.text = firstChar.toString()
                binding.dash2.visibility = View.VISIBLE
                binding.letter2.text = secondChar.toString()
                binding.dash3.visibility = View.VISIBLE
                binding.letter3.text = thirdChar.toString()
                binding.dash4.visibility = View.VISIBLE
                binding.letter4.text = fourthChar.toString()

                binding.dash5.visibility = View.GONE

                binding.sWordLayout1.visibility = View.VISIBLE
                binding.sWordLayout2.visibility = View.VISIBLE
                binding.sWordLayout3.visibility = View.VISIBLE
                binding.sWordLayout4.visibility = View.VISIBLE
                binding.sWordLayout6.visibility = View.VISIBLE
                binding.sWordLayout7.visibility = View.VISIBLE
                binding.sWordLayout8.visibility = View.VISIBLE
                binding.sWordLayout9.visibility = View.VISIBLE

                binding.sWord1.text = answerSuggestionsChar[0].toString()
                binding.sWord2.text = answerSuggestionsChar[1].toString()
                binding.sWord3.text = answerSuggestionsChar[2].toString()
                binding.sWord4.text = answerSuggestionsChar[3].toString()
                binding.sWord6.text = answerSuggestionsChar[4].toString()
                binding.sWord7.text = answerSuggestionsChar[5].toString()
                binding.sWord8.text = answerSuggestionsChar[6].toString()
                binding.sWord9.text = answerSuggestionsChar[7].toString()

                binding.sWordLayout1.setOnClickListener {
                    if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout1.isEnabled = false
                }
                binding.sWordLayout2.setOnClickListener {
                    if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout2.isEnabled = false
                }
                binding.sWordLayout3.setOnClickListener {
                    if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout3.isEnabled = false
                }
                binding.sWordLayout4.setOnClickListener {
                    if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout4.isEnabled = false
                }

                binding.sWordLayout5.visibility = View.GONE

                binding.sWordLayout6.setOnClickListener {
                    if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout6.isEnabled = false
                }
                binding.sWordLayout7.setOnClickListener {
                    if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout7.isEnabled = false
                }
                binding.sWordLayout8.setOnClickListener {
                    if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout8.isEnabled = false
                }
                binding.sWordLayout9.setOnClickListener {
                    if (answerSuggestionsChar[7] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout9.isEnabled = false
                }
            }
            5 -> {
                val firstChar = answersChar[0]
                val secondChar = answersChar[1]
                val thirdChar = answersChar[2]
                val fourthChar = answersChar[3]
                val fifthChar = answersChar[4]

                binding.dash1.visibility = View.VISIBLE
                binding.letter1.text = firstChar.toString()
                binding.dash2.visibility = View.VISIBLE
                binding.letter2.text = secondChar.toString()
                binding.dash3.visibility = View.VISIBLE
                binding.letter3.text = thirdChar.toString()
                binding.dash4.visibility = View.VISIBLE
                binding.letter4.text = fourthChar.toString()
                binding.dash5.visibility = View.VISIBLE
                binding.letter5.text = fifthChar.toString()

                binding.sWordLayout1.visibility = View.VISIBLE
                binding.sWordLayout2.visibility = View.VISIBLE
                binding.sWordLayout3.visibility = View.VISIBLE
                binding.sWordLayout4.visibility = View.VISIBLE
                binding.sWordLayout5.visibility = View.VISIBLE
                binding.sWordLayout6.visibility = View.VISIBLE
                binding.sWordLayout7.visibility = View.VISIBLE
                binding.sWordLayout8.visibility = View.VISIBLE
                binding.sWordLayout9.visibility = View.VISIBLE

                binding.sWord1.text = answerSuggestionsChar[0].toString()
                binding.sWord2.text = answerSuggestionsChar[1].toString()
                binding.sWord3.text = answerSuggestionsChar[2].toString()
                binding.sWord4.text = answerSuggestionsChar[3].toString()
                binding.sWord5.text = answerSuggestionsChar[4].toString()
                binding.sWord6.text = answerSuggestionsChar[5].toString()
                binding.sWord7.text = answerSuggestionsChar[6].toString()
                binding.sWord8.text = answerSuggestionsChar[7].toString()
                binding.sWord9.text = answerSuggestionsChar[8].toString()

                binding.sWordLayout1.setOnClickListener {
                    if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[0] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout1.isEnabled = false
                }
                binding.sWordLayout2.setOnClickListener {
                    if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord2.setTextColor(getColor(R.color.white))
                        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[1] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord1.setTextColor(getColor(R.color.white))
                        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout2.isEnabled = false
                }
                binding.sWordLayout3.setOnClickListener {
                    if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[2] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord3.setTextColor(getColor(R.color.white))
                        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout3.isEnabled = false
                }
                binding.sWordLayout4.setOnClickListener {
                    if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[3] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord4.setTextColor(getColor(R.color.white))
                        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout4.isEnabled = false
                }
                binding.sWordLayout5.setOnClickListener {
                    if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord5.setTextColor(getColor(R.color.white))
                        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord5.setTextColor(getColor(R.color.white))
                        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord5.setTextColor(getColor(R.color.white))
                        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord5.setTextColor(getColor(R.color.white))
                        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[4] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord5.setTextColor(getColor(R.color.white))
                        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout5.isEnabled = false
                }
                binding.sWordLayout6.setOnClickListener {
                    if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[5] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord6.setTextColor(getColor(R.color.white))
                        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout6.isEnabled = false
                }
                binding.sWordLayout7.setOnClickListener {
                    if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[6] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord7.setTextColor(getColor(R.color.white))
                        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout7.isEnabled = false
                }
                binding.sWordLayout8.setOnClickListener {
                    if (answerSuggestionsChar[7] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[7] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord8.setTextColor(getColor(R.color.white))
                        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout8.isEnabled = false
                }
                binding.sWordLayout9.setOnClickListener {
                    if (answerSuggestionsChar[8] == firstChar && !binding.letter1.isVisible) {
                        binding.letter1.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[8] == secondChar && !binding.letter2.isVisible) {
                        binding.letter2.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[8] == thirdChar && !binding.letter3.isVisible) {
                        binding.letter3.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[8] == fourthChar && !binding.letter4.isVisible) {
                        binding.letter4.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    } else if (answerSuggestionsChar[8] == fifthChar && !binding.letter5.isVisible) {
                        binding.letter5.visibility = View.VISIBLE
                        binding.sWord9.setTextColor(getColor(R.color.white))
                        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                    }
                    binding.sWordLayout9.isEnabled = false
                }
            }
        }

        binding.finishBtn.setOnClickListener {
            counter++
            if (counter > 4) {
                counter = 0
            }
            resetData()

            binding.questionTxt.text = questions[counter]
            binding.answerImage.setImageResource(answerImages[counter])
            answersChar = answers[counter].toCharArray()
            answerSuggestionsChar = answerSuggestions[counter].toCharArray()

            when (answersChar.size) {
                3 -> {
                    val firstChar = answersChar[0]
                    val secondChar = answersChar[1]
                    val thirdChar = answersChar[2]

                    binding.dash1.visibility = View.VISIBLE
                    binding.letter1.text = firstChar.toString()
                    binding.dash2.visibility = View.VISIBLE
                    binding.letter2.text = secondChar.toString()
                    binding.dash3.visibility = View.VISIBLE
                    binding.letter3.text = thirdChar.toString()

                    binding.dash4.visibility = View.GONE
                    binding.dash5.visibility = View.GONE

                    binding.sWordLayout1.visibility = View.VISIBLE
                    binding.sWordLayout2.visibility = View.VISIBLE
                    binding.sWordLayout3.visibility = View.VISIBLE
                    binding.sWordLayout4.visibility = View.VISIBLE
                    binding.sWordLayout6.visibility = View.VISIBLE
                    binding.sWordLayout7.visibility = View.VISIBLE
                    binding.sWordLayout8.visibility = View.VISIBLE

                    binding.sWord1.text = answerSuggestionsChar[0].toString()
                    binding.sWord2.text = answerSuggestionsChar[1].toString()
                    binding.sWord3.text = answerSuggestionsChar[2].toString()
                    binding.sWord4.text = answerSuggestionsChar[3].toString()
                    binding.sWord6.text = answerSuggestionsChar[4].toString()
                    binding.sWord7.text = answerSuggestionsChar[5].toString()
                    binding.sWord8.text = answerSuggestionsChar[6].toString()

                    binding.sWordLayout1.setOnClickListener {
                        if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout1.isEnabled = false
                    }

                    binding.sWordLayout2.setOnClickListener {
                        if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout2.isEnabled = false
                    }

                    binding.sWordLayout3.setOnClickListener {
                        if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout3.isEnabled = false
                    }

                    binding.sWordLayout4.setOnClickListener {
                        if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout4.isEnabled = false
                    }

                    binding.sWordLayout5.visibility = View.GONE

                    binding.sWordLayout6.setOnClickListener {
                        if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout6.isEnabled = false
                    }

                    binding.sWordLayout7.setOnClickListener {
                        if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout7.isEnabled = false
                    }

                    binding.sWordLayout8.setOnClickListener {
                        if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout8.isEnabled = false
                    }

                    binding.sWordLayout9.visibility = View.GONE
                }
                4 -> {
                    val firstChar = answersChar[0]
                    val secondChar = answersChar[1]
                    val thirdChar = answersChar[2]
                    val fourthChar = answersChar[3]

                    binding.dash1.visibility = View.VISIBLE
                    binding.letter1.text = firstChar.toString()
                    binding.dash2.visibility = View.VISIBLE
                    binding.letter2.text = secondChar.toString()
                    binding.dash3.visibility = View.VISIBLE
                    binding.letter3.text = thirdChar.toString()
                    binding.dash4.visibility = View.VISIBLE
                    binding.letter4.text = fourthChar.toString()

                    binding.dash5.visibility = View.GONE

                    binding.sWordLayout1.visibility = View.VISIBLE
                    binding.sWordLayout2.visibility = View.VISIBLE
                    binding.sWordLayout3.visibility = View.VISIBLE
                    binding.sWordLayout4.visibility = View.VISIBLE
                    binding.sWordLayout6.visibility = View.VISIBLE
                    binding.sWordLayout7.visibility = View.VISIBLE
                    binding.sWordLayout8.visibility = View.VISIBLE
                    binding.sWordLayout9.visibility = View.VISIBLE

                    binding.sWord1.text = answerSuggestionsChar[0].toString()
                    binding.sWord2.text = answerSuggestionsChar[1].toString()
                    binding.sWord3.text = answerSuggestionsChar[2].toString()
                    binding.sWord4.text = answerSuggestionsChar[3].toString()
                    binding.sWord6.text = answerSuggestionsChar[4].toString()
                    binding.sWord7.text = answerSuggestionsChar[5].toString()
                    binding.sWord8.text = answerSuggestionsChar[6].toString()
                    binding.sWord9.text = answerSuggestionsChar[7].toString()

                    binding.sWordLayout1.setOnClickListener {
                        if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout1.isEnabled = false
                    }
                    binding.sWordLayout2.setOnClickListener {
                        if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout2.isEnabled = false
                    }
                    binding.sWordLayout3.setOnClickListener {
                        if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout3.isEnabled = false
                    }
                    binding.sWordLayout4.setOnClickListener {
                        if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout4.isEnabled = false
                    }

                    binding.sWordLayout5.visibility = View.GONE

                    binding.sWordLayout6.setOnClickListener {
                        if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout6.isEnabled = false
                    }
                    binding.sWordLayout7.setOnClickListener {
                        if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout7.isEnabled = false
                    }
                    binding.sWordLayout8.setOnClickListener {
                        if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout8.isEnabled = false
                    }
                    binding.sWordLayout9.setOnClickListener {
                        if (answerSuggestionsChar[7] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout9.isEnabled = false
                    }
                }
                5 -> {
                    val firstChar = answersChar[0]
                    val secondChar = answersChar[1]
                    val thirdChar = answersChar[2]
                    val fourthChar = answersChar[3]
                    val fifthChar = answersChar[4]

                    binding.dash1.visibility = View.VISIBLE
                    binding.letter1.text = firstChar.toString()
                    binding.dash2.visibility = View.VISIBLE
                    binding.letter2.text = secondChar.toString()
                    binding.dash3.visibility = View.VISIBLE
                    binding.letter3.text = thirdChar.toString()
                    binding.dash4.visibility = View.VISIBLE
                    binding.letter4.text = fourthChar.toString()
                    binding.dash5.visibility = View.VISIBLE
                    binding.letter5.text = fifthChar.toString()

                    binding.sWordLayout1.visibility = View.VISIBLE
                    binding.sWordLayout2.visibility = View.VISIBLE
                    binding.sWordLayout3.visibility = View.VISIBLE
                    binding.sWordLayout4.visibility = View.VISIBLE
                    binding.sWordLayout5.visibility = View.VISIBLE
                    binding.sWordLayout6.visibility = View.VISIBLE
                    binding.sWordLayout7.visibility = View.VISIBLE
                    binding.sWordLayout8.visibility = View.VISIBLE
                    binding.sWordLayout9.visibility = View.VISIBLE

                    binding.sWord1.text = answerSuggestionsChar[0].toString()
                    binding.sWord2.text = answerSuggestionsChar[1].toString()
                    binding.sWord3.text = answerSuggestionsChar[2].toString()
                    binding.sWord4.text = answerSuggestionsChar[3].toString()
                    binding.sWord5.text = answerSuggestionsChar[4].toString()
                    binding.sWord6.text = answerSuggestionsChar[5].toString()
                    binding.sWord7.text = answerSuggestionsChar[6].toString()
                    binding.sWord8.text = answerSuggestionsChar[7].toString()
                    binding.sWord9.text = answerSuggestionsChar[8].toString()

                    binding.sWordLayout1.setOnClickListener {
                        if (answerSuggestionsChar[0] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[0] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout1.isEnabled = false
                    }
                    binding.sWordLayout2.setOnClickListener {
                        if (answerSuggestionsChar[1] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord2.setTextColor(getColor(R.color.white))
                            binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[1] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord1.setTextColor(getColor(R.color.white))
                            binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout2.isEnabled = false
                    }
                    binding.sWordLayout3.setOnClickListener {
                        if (answerSuggestionsChar[2] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[2] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord3.setTextColor(getColor(R.color.white))
                            binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout3.isEnabled = false
                    }
                    binding.sWordLayout4.setOnClickListener {
                        if (answerSuggestionsChar[3] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[3] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord4.setTextColor(getColor(R.color.white))
                            binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout4.isEnabled = false
                    }
                    binding.sWordLayout5.setOnClickListener {
                        if (answerSuggestionsChar[4] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord5.setTextColor(getColor(R.color.white))
                            binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord5.setTextColor(getColor(R.color.white))
                            binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord5.setTextColor(getColor(R.color.white))
                            binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord5.setTextColor(getColor(R.color.white))
                            binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[4] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord5.setTextColor(getColor(R.color.white))
                            binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout5.isEnabled = false
                    }
                    binding.sWordLayout6.setOnClickListener {
                        if (answerSuggestionsChar[5] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[5] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord6.setTextColor(getColor(R.color.white))
                            binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout6.isEnabled = false
                    }
                    binding.sWordLayout7.setOnClickListener {
                        if (answerSuggestionsChar[6] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[6] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord7.setTextColor(getColor(R.color.white))
                            binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout7.isEnabled = false
                    }
                    binding.sWordLayout8.setOnClickListener {
                        if (answerSuggestionsChar[7] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[7] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord8.setTextColor(getColor(R.color.white))
                            binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout8.isEnabled = false
                    }
                    binding.sWordLayout9.setOnClickListener {
                        if (answerSuggestionsChar[8] == firstChar && !binding.letter1.isVisible) {
                            binding.letter1.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[8] == secondChar && !binding.letter2.isVisible) {
                            binding.letter2.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[8] == thirdChar && !binding.letter3.isVisible) {
                            binding.letter3.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[8] == fourthChar && !binding.letter4.isVisible) {
                            binding.letter4.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        } else if (answerSuggestionsChar[8] == fifthChar && !binding.letter5.isVisible) {
                            binding.letter5.visibility = View.VISIBLE
                            binding.sWord9.setTextColor(getColor(R.color.white))
                            binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_4)
                        }
                        binding.sWordLayout9.isEnabled = false
                    }
                }
            }


        }
    }

    private fun resetData() {
        binding.letter1.visibility = View.GONE
        binding.letter2.visibility = View.GONE
        binding.letter3.visibility = View.GONE
        binding.letter4.visibility = View.GONE
        binding.letter5.visibility = View.GONE

        binding.sWordLayout1.isEnabled = true
        binding.sWordLayout2.isEnabled = true
        binding.sWordLayout3.isEnabled = true
        binding.sWordLayout4.isEnabled = true
        binding.sWordLayout5.isEnabled = true
        binding.sWordLayout6.isEnabled = true
        binding.sWordLayout7.isEnabled = true
        binding.sWordLayout8.isEnabled = true
        binding.sWordLayout9.isEnabled = true

        binding.sWord1.setTextColor(getColor(R.color.sword))
        binding.sWordLayout1.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord2.setTextColor(getColor(R.color.sword))
        binding.sWordLayout2.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord3.setTextColor(getColor(R.color.sword))
        binding.sWordLayout3.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord4.setTextColor(getColor(R.color.sword))
        binding.sWordLayout4.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord5.setTextColor(getColor(R.color.sword))
        binding.sWordLayout5.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord6.setTextColor(getColor(R.color.sword))
        binding.sWordLayout6.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord7.setTextColor(getColor(R.color.sword))
        binding.sWordLayout7.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord8.setTextColor(getColor(R.color.sword))
        binding.sWordLayout8.setBackgroundResource(R.drawable.button_bg_2)
        binding.sWord9.setTextColor(getColor(R.color.sword))
        binding.sWordLayout9.setBackgroundResource(R.drawable.button_bg_2)
    }

}