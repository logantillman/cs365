// Author: Logan Tillman

#include <vector>
#include "Queue.h"

using namespace std;

void ArrayQueue::add(int value) {
	vec.push_back(value);
}
	
int ArrayQueue::remove() {
	int rv = vec.at(0);
	vec.erase(vec.begin());
	return rv;
}

bool ArrayQueue::isEmpty() {
	if (vec.size() == 0)
		return true;
	else
		return false;
}

