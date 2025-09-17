class FoodEntry {
    String food;
    int rating;

    FoodEntry(String food, int rating) {
        this.food = food;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodEntry)) return false;
        FoodEntry f = (FoodEntry) o;
        return rating == f.rating && food.equals(f.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, rating);
    }
}

class FoodRatings {

    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, PriorityQueue<FoodEntry>> topRated = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);

            topRated.putIfAbsent(cuisines[i], new PriorityQueue<>(
                (a, b) -> {
                    if (a.rating != b.rating) return b.rating - a.rating; 
                    return a.food.compareTo(b.food); 
                }
            ));

            topRated.get(cuisines[i]).offer(new FoodEntry(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        foodToRating.put(food, newRating);

        topRated.get(cuisine).remove(new FoodEntry(food, oldRating));
        topRated.get(cuisine).offer(new FoodEntry(food, newRating));
    }

    public String highestRated(String cuisine) {
        return topRated.get(cuisine).peek().food;
    }
}
