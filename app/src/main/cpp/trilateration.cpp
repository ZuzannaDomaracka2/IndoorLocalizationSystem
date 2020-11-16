#include <iostream>
#include <vector>
#include <utility>
#include <cmath>
#include <cassert>

using std::vector;
using std::pair;

typedef pair<double, double> CoordinatesXY;
// [BEGIN] Mock code for testing (not required later)
class Beacon {
public:
	double PositionX;
	double PositionY;
	int Id;
	static int NextID;
	Beacon(CoordinatesXY coords) {
		PositionX = coords.first;
		PositionY = coords.second;
		Id = NextID++;
		std::cout << "Beacon pos (x,y) (" << PositionX << "," << PositionY << ") with ID: "<<Id<<" has been created.\n";
	}
};
int Beacon::NextID = 0;

// Create fixed location of Beacons
void AddBeacons(vector<Beacon>& Beacons) {
	CoordinatesXY coords(10.0,10.0);
	Beacons.push_back(Beacon(coords));
	coords = std::make_pair(10.0,20.0);
	Beacons.push_back(Beacon(coords));
	coords = std::make_pair(20.0, 20.0);
	Beacons.push_back(Beacon(coords));
}

// Add distances from Beacons. Assuming distance at index 'x' in vector Distances  is distance from Beacon at index 'x' in Beacons vector.
// IMPORTANT NOTE DISTANCES ARE DISTANCES MAPPED TO 2D plane!
void AddDistances(vector<double>& Distances) {
	Distances.push_back(10.0);
	Distances.push_back(13.0*sqrt(2));
	Distances.push_back(10.0);
}
// [END] Mock code for testing (not required later)
class Trilateration {
public:
	// First attempt with circle equation. Pros - fast. Cons - is using only 3 distances.
	CoordinatesXY Trilaterate(const vector<double>& Distances, const vector<Beacon>& Beacons) {
		CoordinatesXY result;
		assert(Distances.size() >= 3u);
		assert(Beacons.size() >= 3u);
		assert(Beacons.size() == Distances.size());

		double A = -2.0 * Beacons[0].PositionX + 2.0 * Beacons[1].PositionX;
		double B = -2.0 * Beacons[0].PositionY + 2.0 * Beacons[1].PositionY;
		double C = pow(Distances[0], 2) - pow(Distances[1], 2) - pow(Beacons[0].PositionX, 2) + pow(Beacons[1].PositionX, 2) - pow(Beacons[0].PositionY, 2) + pow(Beacons[1].PositionY, 2);
		double D = -2.0 * Beacons[1].PositionX + 2.0 * Beacons[2].PositionX;
		double E = -2.0 * Beacons[1].PositionY + 2.0 * Beacons[2].PositionY;
		double F = pow(Distances[1], 2) - pow(Distances[2], 2) - pow(Beacons[1].PositionX, 2) + pow(Beacons[2].PositionX, 2) - pow(Beacons[1].PositionY, 2) + pow(Beacons[2].PositionY, 2);

		result.first = (C * E - F * B) / (E * A - B * D);
		result.second = (C * D - F * A) / (B * D - A * E);
		return result;
	}
	CoordinatesXY TrilaterateLSM(const vector<double>& Distances, const vector<Beacon>& Beacons) {
		CoordinatesXY result(0,0);
		
		// Implement Least square algorithm for better results or similar function to pythons scipy.optimize.minimize

		return result;
	}
};

int main(int argc, char* argv) {
	std::cout << "Begin testing:\n";
	std::cout << "Adding beacons:\n";
	vector<Beacon> Beacons;
	AddBeacons(Beacons);

	std::cout << "Adding lengths:\n";
	vector<double> Distances;
	AddDistances(Distances);

	std::cout << "Create Trillateration object:\n";
	Trilateration* trillaterationObj = new Trilateration();
	//CoordinatesXY result = trillaterationObj->TrilaterateLSM(Distances, Beacons);
	CoordinatesXY result = trillaterationObj->Trilaterate(Distances, Beacons);
	std::cout << "Result is (x,y) (" << result.first << "," << result.second << ").\n";
	return 0;
}