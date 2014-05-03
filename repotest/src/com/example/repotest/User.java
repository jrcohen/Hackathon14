package com.example.repotest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.Application;
import android.location.*;
import android.provider.Settings;

public class User extends Application {
	
	String userName;
	String userGroup;
	
	public User(){
		this.userName = null;
		this.userGroup = null;
	}
	
	public User(String name, String group){
		this.userName = name;
		this.userGroup = group;
	}
	
	public String getName(){
		return this.userName;
	}
	
	
}