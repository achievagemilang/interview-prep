package main

import (
	"log"
	"sync"
)

func f(x int) int {
	return 2 * x
}

func main() {
	numWorkers := 5
	jobs := make(chan int)
	wg := &sync.WaitGroup{}

	for i := 0; i < numWorkers; i++ {
		wg.Add(1)
		go runWorkers(jobs, i, wg)
	}

	for i := 1; i <= 10; i++ {
		jobs <- i
	}

	close(jobs)

	wg.Wait()
}

func runWorkers(jobs chan int, id int, wg *sync.WaitGroup) {
	defer wg.Done()
	for job := range jobs {
		y := f(job)
		log.Printf("Worker %d processed %d, result is %d", id, job, y)
	}
}
