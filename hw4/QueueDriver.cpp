// Author: Logan Tillman

#include <cstdio>
#include "Queue.h"

int main() {
	Queue *queue = new ArrayQueue;

	queue->add(3);
	queue->add(10);
	queue->add(5);

	printf("%d\n%d", queue->remove(), queue->remove());

	queue->add(6);
	queue->add(9);
	queue->add(12);

	while (!queue->isEmpty()) {
		printf("%d\n", queue->remove());
	}
	return 0;
}
