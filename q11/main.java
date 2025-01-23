JPanel panel = new JPanel(new FlowLayout());
panel.add(new JButton("Button 1"));
panel.add(new JButton("Button 2"));
panel.add(new JButton("Button 3"));

JPanel panel = new JPanel(new BorderLayout());
panel.add(new JButton("North"), BorderLayout.NORTH);
panel.add(new JButton("South"), BorderLayout.SOUTH);
panel.add(new JButton("Center"), BorderLayout.CENTER);
