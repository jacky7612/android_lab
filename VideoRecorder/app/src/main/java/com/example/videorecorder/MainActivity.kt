package com.example.videorecorder

import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var recorder:MediaRecorder?=null
    private val VIDEO_CAPTURE = 101
    var videoView:VideoView?=null
    var mediaController:MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()
/*
        var button_start_recording = findViewById<Button>(R.id.button_start_recording)
        button_start_recording.isEnabled = hasCamera()
        button_start_recording.setOnClickListener() {
            configureVideoView()
            //val mVideoView = findViewById<View>(R.id.video_view) as VideoView
            //mVideoView.setVideoPath("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
            //val mediaController = MediaController(this)
            //mediaController.setAnchorView(mVideoView)
            //mVideoView.setMediaController(mediaController)
            //mVideoView.requestFocus()
            //mVideoView.setOnPreparedListener { mVideoView.start() }
        }

 */
        /*
        // Create MediaRecorder
        recorder?.setVideoSize(640, 480)
        recorder?.setVideoFrameRate(16) //might be auto-determined due to lighting
        recorder?.setVideoEncodingBitRate(3000000)
        recorder?.setVideoEncoder(MediaRecorder.VideoEncoder.H264)// MPEG_4_SP
        recorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        val cpHigh = CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH)
        recorder?.setProfile(cpHigh)

        var button_start_recording = findViewById<Button>(R.id.button_start_recording)
        button_start_recording.isEnabled = hasCamera()

        button_start_recording.setOnClickListener {
            // 指定開啟系統相機的Action
            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)

            val mediaFile = File(
                Environment.getExternalStorageDirectory().absolutePath + "/myvideo.mp4"
            )
            var videoUri: Uri? = null
            videoUri = Uri.fromFile(mediaFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
            intent.putExtra("android.intent.extra.durationLimit", 30);
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1); //to open front facing camera

            startActivityForResult(intent, VIDEO_CAPTURE)
        }

         */
    }
    private fun playVideo()
    {
        var videoUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"

        videoView = findViewById<Button>(R.id.videoView) as VideoView?

        if (mediaController == null) {
            // creating object of media controller class
            mediaController = MediaController(this)

            // sets the anchor view anchor view for the videoView
            mediaController!!.setAnchorView(this.videoView)

            // sets the media player to the videoView
            //mediaController!!.setMediaPlayer(this.videoView)
        }
        // sets the media controller to the videoView
        videoView!!.setMediaController(mediaController)
        // sets the resource from the videoUrl to the videoView
        videoView!!.setVideoURI(Uri.parse(videoUrl))
        //videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.sample))
        videoView!!.requestFocus()

        // starts the video
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "video End", Toast.LENGTH_LONG).show()
        }
        videoView!!.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }
    }
    private fun hasCamera(): Boolean {
        return packageManager.hasSystemFeature(
            PackageManager.FEATURE_CAMERA_ANY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val videoUri = data?.data

        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this, "Video saved to:\n"
                            + videoUri, Toast.LENGTH_LONG
                ).show()
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(
                    this, "Video recording cancelled.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this, "Failed to record video",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        /*
        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this, """
                 Video has been saved to:
                 ${data?.data}
                 """.trimIndent(), Toast.LENGTH_LONG
                ).show()
                playbackRecordedVideo()
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to record video", Toast.LENGTH_LONG).show()
            }
        }
         */
    }
/*
    var videoUri: Uri? = null
    fun startRecordingVideo() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            val mediaFile = File(
                Environment.getExternalStorageDirectory().absolutePath + "/myvideo.mp4"
            )
            videoUri = Uri.fromFile(mediaFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri)
            startActivityForResult(intent, VIDEO_CAPTURE)
        } else {
            Toast.makeText(this, "No camera on device", Toast.LENGTH_LONG).show()
        }
    }

    fun playbackRecordedVideo() {
        val mVideoView = findViewById<View>(R.id.video_view) as VideoView
        mVideoView.setVideoURI(videoUri)
        mVideoView.setMediaController(MediaController(this))
        mVideoView.requestFocus()
        mVideoView.start()
    }

 */
}