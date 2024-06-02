package com.example.demo.service;


	import java.sql.Connection;

	import com.example.dao.CityOperationDao;
	import com.example.model.latLong;

	public class servicesuite {

		private CityOperation cityOperationDao = new CityOperationDao();

		public String checkCityAvailability(String city1, String city2, Connection dbconnection) {
			boolean res = cityOperationDao.checkcityexist(city1, dbconnection);
			boolean res1 = cityOperationDao.checkcityexist(city2, dbconnection);

			if (res && res1) {
				latLong lat1 = cityOperationDao.getCityCoordinates(city1, dbconnection);
				latLong lat2 = cityOperationDao.getCityCoordinates(city2, dbconnection);
				if (lat1 != null && lat2 != null) {
					String dist = calculateDistance(lat1, lat2);
					return "the distance present between two city is " + dist;
				} else {
					return "latlong does not exist";
				}
			}

			else if (!res && !res1) {
				return "Neither city exists";
			} else if (!res) {
				return "City " + city1 + " does not exist";
			} else {
				return "City " + city2 + " does not exist";
			}
		}

		public String calculateDistance(latLong l, latLong l1) {
			final int R = 6371; // Radius of the Earth in kilometers

			double lat1 = Math.toRadians(l.getLat());
			double lon1 = Math.toRadians(l.getLog());
			double lat2 = Math.toRadians(l1.getLat());
			double lon2 = Math.toRadians(l1.getLog());

			double dLat = lat2 - lat1;
			double dLon = lon2 - lon1;

			double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
					+ Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

			return R * c + "";
		}
	}
   }

