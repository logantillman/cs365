#include "queue.h"

typedef struct Queue {
	public:
		void *queue_new(int numItems);  // create a queue that can hold the indicated number of items
		void queue_enqueue(void *q, void *item); // add the element to the back of the queue
		void *queue_dequeue(void *q); // remove and return the element at the front of the queue
		int queue_isEmpty(void *q);   // 1 if empty and 0 otherwise
	private:
		void *front;
		void *back;
		int size;
		void *array;
} myQueue;

void *queue_new(int numItems) {
	myQueue *newQueue = (myQueue *) malloc(sizeof(myQueue));
	newQueue->size = numItems;
	newQueue->array = (void *) malloc(sizeof(void *) * numItems);
	newQueue->front = newQueue->array[0];
	newQueue->back = newQueue->array[numItems - 1];
	return (void *) newQueue;
}

void queue_enqueue(void *q, void *item) {

}

void *queue_dequeue(void *q) {

}

int queue_isEmpty(void *q) {

}
