public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    // Constructor
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getter methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }

    // Magnitude of the vector
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Normalize the vector
    public Vector3D normalize() {
        double magnitude = getMagnitude();
        if (magnitude == 0) {
            throw new IllegalStateException("Cannot normalize a zero vector.");
        }
        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    // Add another vector
    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Multiply by a constant
    public Vector3D multiply(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Dot product
    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Angle between two vectors
    public double angleBetween(Vector3D other) {
        double dot = this.dotProduct(other);
        double magnitudeProduct = this.getMagnitude() * other.getMagnitude();
        if (magnitudeProduct == 0) {
            throw new IllegalStateException("Cannot calculate the angle with a zero vector.");
        }
        return Math.toDegrees(Math.acos(dot / magnitudeProduct));
    }

    // Cross product
    public Vector3D crossProduct(Vector3D other) {
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;
        return new Vector3D(crossX, crossY, crossZ);
    }

    // Main method for testing
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D v2 = new Vector3D(4.0, 5.0, 6.0);

        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);

        System.out.println("Magnitude of v1: " + v1.getMagnitude());
        System.out.println("Normalized v1: " + v1.normalize());

        System.out.println("v1 + v2: " + v1.add(v2));
        System.out.println("v1 * 2: " + v1.multiply(2));

        System.out.println("Dot product of v1 and v2: " + v1.dotProduct(v2));
        System.out.println("Angle between v1 and v2: " + v1.angleBetween(v2));

        System.out.println("Cross product of v1 and v2: " + v1.crossProduct(v2));
    }
}
