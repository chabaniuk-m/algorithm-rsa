from crypto.Cipher import PKCS1_OAEP
from crypto.PublicKey import RSA

# Generate RSA key pair
key = RSA.generate(2048)

# Get the public and private keys
public_key = key.publickey()
private_key = key

# Encrypt and decrypt a message
message = "Hello, RSA!"
cipher = PKCS1_OAEP.new(public_key)
ciphertext = cipher.encrypt(message.encode('utf-8'))

decipher = PKCS1_OAEP.new(private_key)
decrypted_message = decipher.decrypt(ciphertext).decode('utf-8')

print("Original Message:", message)
print("Decrypted Message:", decrypted_message)
