package com.hotels.project;

import com.hotels.project.cart.Packer;
import com.hotels.project.cart.billing.Billing;
import com.hotels.project.common.Configuration;
import com.hotels.project.dataload.DataFeeder;

public class ApplicationStarter {

	public static void main(String[] args) {
		new Configuration();
		new DataFeeder();

		new Billing().calculateBill();
		new Packer();

	}

}
