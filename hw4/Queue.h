// Author: Logan Tillman

#include <vector>
using namespace std;

class Queue {
public:
	virtual void add(int value);
	virtual int remove();
	virtual bool isEmpty();
};

class ArrayQueue : public Queue {
public:
	void add(int value);
	int remove();
	bool isEmpty();
private:
	std::vector<int> vec;
};

