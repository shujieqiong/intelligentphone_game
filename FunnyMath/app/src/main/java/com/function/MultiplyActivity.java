package com.function;

import com.data.AddData;
import com.data.CommonDatas;
import com.data.MultiplyData;
import com.example.funnymath.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MultiplyActivity extends Activity implements TextToSpeech.OnInitListener {
	// ViewPager是google SDk中自带的一个附加包的一个类，可以用来实现屏幕间的切换。
	// android-support-v4.jar
	private ViewPager mPager;// 页卡内容
	private List<View> listViews; // Tab页面列表
	private TextView textView_head;// 页卡头标

	private int currIndex = 0;// 当前页卡编号

	private View multiply_page0;
	private View multiply_page1;
	private View multiply_page2;
	private View multiply_page3;
	private View multiply_page4;
	private View multiply_page5;
	private View multiply_page6;
	private View multiply_page7;
	private View multiply_page8;
	private View multiply_page9;

	private TextView multiply_textView1;
	private TextView multiply_textView2;
	private RadioGroup multiply_radioGroup;
	private RadioButton multiply_radioButtonA;
	private RadioButton multiply_radioButtonB;
	private RadioButton multiply_radioButtonC;
	private RadioButton multiply_radioButtonD;
	private Random random = new Random();
	private int rightFlag;	//判断选项是否正确
	private ImageView imageView_difficulty;
	private ImageView  imageView_voice;
	private ImageView  imageView_help;
	private ImageView  imageView_teach;
	private TextToSpeech tts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiply);
		tts = new TextToSpeech(this,this);

		InitTextView(); // 初始化头标
		InitViewPager(); // 初始化ViewPager
	}

	/**
	 * 初始化头标，初始化头标和页面一起变
	 */
	private void InitTextView() {
		textView_head = (TextView) findViewById(R.id.text);//
		textView_head.setText("NO.1");
		textView_head.setOnClickListener(new MyOnClickListener(0));
	}

	/**
	 * 初始化ViewPager
	 */
	private void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.vPager);
		listViews = new ArrayList<View>();
		LayoutInflater mInflater = getLayoutInflater();//
		multiply_page0 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page1 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page2 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page3 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page4 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page5 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page6 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page7 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page8 = mInflater.inflate(R.layout.multiply_pager, null);
		multiply_page9 = mInflater.inflate(R.layout.multiply_pager, null);
		listViews.add(multiply_page0);
		listViews.add(multiply_page1);
		listViews.add(multiply_page2);
		listViews.add(multiply_page3);
		listViews.add(multiply_page4);
		listViews.add(multiply_page5);
		listViews.add(multiply_page6);
		listViews.add(multiply_page7);
		listViews.add(multiply_page8);
		listViews.add(multiply_page9);
		mPager.setAdapter(new MyPagerAdapter(listViews));
		mPager.setCurrentItem(0);
		// 对add_page0中的数据初始化
		initAddPage(multiply_page0);
		setData();
		//对viewPager添加页面监听
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			//Toast.makeText(MultiplyActivity.this, "成功输出语音", Toast.LENGTH_SHORT).show();
			// 设置使用美式英语朗读
			int result = tts.setLanguage(Locale.US);


			// 如果不支持所设置的语言
			if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
			&& result != TextToSpeech.LANG_AVAILABLE) {
//				Toast.makeText(MultiplyActivity.this, "TTS暂时不支持这种语言的朗读",
//						Toast.LENGTH_LONG).show();
			}

		}
	}

	/**
	 * ViewPager适配器，自己添加
	 */
	public class MyPagerAdapter extends PagerAdapter {
		public List<View> mListViews;

		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	};

	/**
	 * 页卡切换监听，给页卡加入监听器来进行头标的变化
	 */
	public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
				case 0:
					if (currIndex == 1) {
						textView_head.setText("NO.1");
					}
					break;
				case 1:
					if (currIndex == 0) {
						textView_head.setText("NO.2");
						initAddPage(multiply_page1);
						setData();
					} else if (currIndex == 2) {
						textView_head.setText("NO.2");
					}
					break;
				case 2:
					if (currIndex == 1) {
						textView_head.setText("NO.3");

						initAddPage(multiply_page2);
						setData();
					} else if (currIndex == 3) {
						textView_head.setText("NO.3");
					}
					break;
				case 3:
					if (currIndex == 2) {
						textView_head.setText("NO.4");
						initAddPage(multiply_page3);
						setData();
					} else if (currIndex == 4) {
						textView_head.setText("NO.4");
					}
					break;
				case 4:
					if (currIndex == 3) {
						textView_head.setText("NO.5");
						initAddPage(multiply_page4);
						setData();
					} else if (currIndex == 5) {
						textView_head.setText("NO.5");
					}
					break;
				case 5:
					if (currIndex == 4) {
						textView_head.setText("NO.6");
						initAddPage(multiply_page5);
						setData();
					} else if (currIndex == 6) {
						textView_head.setText("NO.6");
					}
					break;
				case 6:
					if (currIndex == 5) {
						textView_head.setText("NO.7");
						initAddPage(multiply_page6);
						setData();
					} else if (currIndex == 7) {
						textView_head.setText("NO.7");
					}
					break;
				case 7:
					if (currIndex == 6) {
						textView_head.setText("NO.8");
						initAddPage(multiply_page7);
						setData();
					} else if (currIndex == 8) {
						textView_head.setText("NO.8");
					}
					break;
				case 8:
					if (currIndex == 7) {
						textView_head.setText("NO.9");
						initAddPage(multiply_page8);
						setData();
					} else if (currIndex == 9) {
						textView_head.setText("NO.9");
					}
					break;
				case 9:
					if (currIndex == 8) {
						textView_head.setText("NO.10");
						initAddPage(multiply_page9);
						setData();
					}
					break;
			}
			currIndex = arg0;//记录当前页面


		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	public void changeToNext() {
		final int nowItem = mPager.getCurrentItem();
		if (nowItem < listViews.size()-1) {
			mPager.setCurrentItem(nowItem+1);
		}
	}

	class myCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
				case R.id.multiply_radioButtonA:
					if (getRightFlag() == 1) {
						Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
								Toast.LENGTH_SHORT).show();
						changeToNext();
					} else {
						Toast.makeText(getApplicationContext(), "不对，再想想~",
								Toast.LENGTH_SHORT).show();
					}
					break;
				case R.id.multiply_radioButtonB:
					if (getRightFlag() == 2) {
						Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
								Toast.LENGTH_SHORT).show();
						changeToNext();
					} else {
						Toast.makeText(getApplicationContext(), "不对，再想想~",
								Toast.LENGTH_SHORT).show();
					}
					break;
				case R.id.multiply_radioButtonC:
					if (getRightFlag() == 3) {
						Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
								Toast.LENGTH_SHORT).show();
						changeToNext();
					} else {
						Toast.makeText(getApplicationContext(), "不对，再想想~",
								Toast.LENGTH_SHORT).show();
					}
					break;
				case R.id.multiply_radioButtonD:
					if (getRightFlag() == 4) {
						Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
								Toast.LENGTH_SHORT).show();
						changeToNext();
					} else {
						Toast.makeText(getApplicationContext(), "不对，再想想~",
								Toast.LENGTH_SHORT).show();
					}
					break;
				default:
					break;
			}
		}

	}

	public int getRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(int rightFlag) {
		this.rightFlag = rightFlag;
	}

	public void setData() {
		MultiplyData multiplyData = new MultiplyData();
		multiply_textView1.setText(multiplyData.getQuestion1());
		multiply_textView2.setText(multiplyData.getQuestion2());
		setRightFlag(random.nextInt(4) + 1);//随机生成选项
		switch (rightFlag) {
			case 1:
				multiply_radioButtonA.setText(multiplyData.getAnswer());
				multiply_radioButtonB.setText(multiplyData.getAnswer1());
				multiply_radioButtonC.setText(multiplyData.getAnswer2());
				multiply_radioButtonD.setText(multiplyData.getAnswer3());
				break;
			case 2:
				multiply_radioButtonB.setText(multiplyData.getAnswer());
				multiply_radioButtonA.setText(multiplyData.getAnswer1());
				multiply_radioButtonC.setText(multiplyData.getAnswer2());
				multiply_radioButtonD.setText(multiplyData.getAnswer3());
				break;
			case 3:
				multiply_radioButtonC.setText(multiplyData.getAnswer());
				multiply_radioButtonA.setText(multiplyData.getAnswer1());
				multiply_radioButtonB.setText(multiplyData.getAnswer2());
				multiply_radioButtonD.setText(multiplyData.getAnswer3());
				break;
			case 4:
				multiply_radioButtonD.setText(multiplyData.getAnswer());
				multiply_radioButtonA.setText(multiplyData.getAnswer1());
				multiply_radioButtonB.setText(multiplyData.getAnswer2());
				multiply_radioButtonC.setText(multiplyData.getAnswer3());
				break;
			default:
				break;
		}
		//给radioGroup添加监听器
		multiply_radioGroup.setOnCheckedChangeListener(new myCheckedChangeListener());
	}

	private void initAddPage(View view) {
		multiply_textView1 = (TextView) view.findViewById(R.id.multiply_textView1);
		multiply_textView2 = (TextView) view.findViewById(R.id.multiply_textView2);
		multiply_radioGroup = (RadioGroup) view.findViewById(R.id.multiply_radioGroup);
		multiply_radioButtonA = (RadioButton) view.findViewById(R.id.multiply_radioButtonA);
		multiply_radioButtonB = (RadioButton) view.findViewById(R.id.multiply_radioButtonB);
		multiply_radioButtonC = (RadioButton) view.findViewById(R.id.multiply_radioButtonC);
		multiply_radioButtonD = (RadioButton) view.findViewById(R.id.multiply_radioButtonD);
		imageView_difficulty = (ImageView) view.findViewById(R.id.imageView_difficulty);
		imageView_voice = (ImageView) view.findViewById(R.id.imageView_voice);
		imageView_help = (ImageView) view.findViewById(R.id.imageView_help);
		imageView_teach = (ImageView) view.findViewById(R.id.imageView_teach);
		imageView_difficulty.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MultiplyActivity.this);

				builder.setTitle("提示：");
				builder.setMessage("当前已是最高难度了！");
				builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

		imageView_help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MultiplyActivity.this);

				builder.setTitle("提示：");
				builder.setMessage("再想想吧，不要放弃哦！");
				builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});
		imageView_teach.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MultiplyActivity.this);
				builder.setTitle("乘法：");
				builder.setMessage("理解乘法口诀的意义，能较熟练地用数字的乘法口诀来计算试题的积，会用口诀解决简单的实际问题。");
				builder.setPositiveButton("好的",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								dialog.dismiss();
							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		imageView_voice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tts.speak(multiply_textView1.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
			}
		});
	}
}
