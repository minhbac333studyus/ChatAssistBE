-- Mock User
INSERT INTO user_tb ( username, password) VALUES
                                                 ( 'alice', 'pass123'),
                                                 ( 'bob', 'pass456');

-- Mock Conversation
INSERT INTO conversation_tb ( user_id) VALUES
                                              ( 1),
                                              ( 1),
                                              ( 2);

-- Mock Message
INSERT INTO message_tb ( conversation_id, role, content) VALUES
                                                                ( 1, 'USER', 'Xin chào, hôm nay tập gì đây?'),
                                                                ( 1, 'ASSISTANT', 'Chúng ta sẽ tập ngực và tay.'),
                                                                ( 2, 'USER', 'Hôm qua tôi tập chân.'),
                                                                ( 2, 'ASSISTANT', 'Hôm nay nghỉ.'),
                                                                ( 3, 'USER', 'Hello Bob!'),
                                                                ( 3, 'ASSISTANT', 'Hi Alice!');
SELECT column_default, is_identity
FROM information_schema.columns
WHERE table_name='message_tb' AND column_name='id';